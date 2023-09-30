package com.example.shramvriddhi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityRegister2Binding


class RegisterActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityRegister2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegister2Binding.inflate(layoutInflater)

        binding.BtnSubmitRegister.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}