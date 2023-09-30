package com.example.shramvriddhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.shramvriddhi.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
private lateinit var sendOTPBtn: Button
private lateinit var phoneNumberET: EditText
private lateinit var auth: FirebaseAuth
private lateinit var number : String
private lateinit var mProgressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnRegister.setOnClickListener{

            val q = Intent(this,RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnGuest.setOnClickListener{
            val k = Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }


        init()
        binding.BtnLogin.setOnClickListener {
            number= phoneNumberET.text.trim().toString()

            if (number.isNotEmpty()){
                if (number.length == 10){
                    number = "+91$number"
                    mProgressBar.visibility = View.VISIBLE

                    val options = PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(number)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(callbacks)
                        .build()
                    PhoneAuthProvider.verifyPhoneNumber(options)


                }else{
                    Toast.makeText(this, "Please Enter Correct Number",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please Enter Your Number",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun  init(){
        sendOTPBtn = findViewById(R.id.BtnLogin)
        phoneNumberET =findViewById(R.id.etLoginNo)
        auth= FirebaseAuth.getInstance()
        mProgressBar = findViewById(R.id.progressBar1)
        mProgressBar.visibility = View.INVISIBLE
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Authenticated Sucessfully",Toast.LENGTH_SHORT).show()
                    sendToMAin()
                } else {

                    Log.d("TAG", "signInWithPhoneAuthCredential: ${task.exception.toString()}")

                    if (task.exception is FirebaseAuthInvalidCredentialsException) {

                    }

                }
                mProgressBar.visibility = View.INVISIBLE
            }
    }

    private fun sendToMAin(){
        startActivity(Intent(this,MainActivity::class.java))
    }

    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {


            if (e is FirebaseAuthInvalidCredentialsException) {

                Log.d("TAG", "onVerificationFailed: ${e.toString()}")
            } else if (e is FirebaseTooManyRequestsException) {

                Log.d( "TAG", "onVerificationFailed: ${e.toString()}")
            }

            mProgressBar.visibility = View.VISIBLE
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {

                  val intent = Intent(this@LoginActivity,OtpActivity::class.java)
                  intent.putExtra("OTP", verificationId)
                  intent.putExtra("resendToken", token)
                  intent.putExtra("phoneNumber", number)
                  startActivity(intent)
                  mProgressBar.visibility = View.INVISIBLE
        }

        }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
    }
