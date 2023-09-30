package com.example.shramvriddhi.ui

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
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sendOTPBtn: Button
    private lateinit var phoneNumberET: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var number: String
    private lateinit var mProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        // Fine
        binding.BtnRegister.setOnClickListener {
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnGuest.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.BtnLogin.setOnClickListener {
//            number = phoneNumberET.text.trim().toString()

            mProgressBar.visibility = View.VISIBLE

            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber("+917583022446")
                .setTimeout(30L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(callbacks)
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)

//            if (number.isNotEmpty()) {
//                if (number.length == 10) {
////                    number = "+91$number"
//
//                    mProgressBar.visibility = View.VISIBLE
//
//                    val options = PhoneAuthOptions.newBuilder(auth)
//                        .setPhoneNumber(number)
//                        .setTimeout(30L, TimeUnit.SECONDS)
//                        .setActivity(this)
//                        .setCallbacks(callbacks)
//                        .build()
//                    PhoneAuthProvider.verifyPhoneNumber(options)
//
//                } else {
//                    mProgressBar.visibility = View.INVISIBLE
//                    Toast.makeText(this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                mProgressBar.visibility = View.INVISIBLE
//                Toast.makeText(this, "Please Enter Your Number", Toast.LENGTH_SHORT).show()
//            }
        }

    }

    private fun init() {
        auth = FirebaseAuth.getInstance()
        sendOTPBtn = binding.BtnLogin
        phoneNumberET = binding.etLoginNo
        mProgressBar = binding.progressBar1
        mProgressBar.visibility = View.INVISIBLE
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Authenticated Successfully", Toast.LENGTH_SHORT).show()
                    sendToMAin()
                } else {
                    Log.d("TAG", "signInWithPhoneAuthCredential: ${task.exception.toString()}")
//                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
//                    }
                }
                mProgressBar.visibility = View.INVISIBLE
            }
    }

    private fun sendToMAin() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            if (e is FirebaseAuthInvalidCredentialsException) {
                Log.d("TAG", "onVerificationFailed: ${e.toString()}")
            } else if (e is FirebaseTooManyRequestsException) {
                Log.d("TAG", "onVerificationFailed: ${e.toString()}")
            }

            mProgressBar.visibility = View.VISIBLE
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            Log.d("CodeSentBlock","This is the verificationid $verificationId")
//            val intent = Intent(this@LoginActivity, OtpActivity::class.java)
//            intent.putExtra("OTP", verificationId)
//            intent.putExtra("resendToken", token)
//            intent.putExtra("phoneNumber", number)
//            startActivity(intent)
//            mProgressBar.visibility = View.INVISIBLE
        }

    }

    override fun onStart() {
        super.onStart()
        /*
        If the user is already logged in\
        Take it to the Main Activity
         */
        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
