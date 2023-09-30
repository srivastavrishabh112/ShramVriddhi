package com.example.shramvriddhi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityRaiseClaim2Binding


class RaiseClaim2 : AppCompatActivity() {
    private lateinit var binding: ActivityRaiseClaim2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRaiseClaim2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView43.animate().apply {
            duration = 1500
            rotationY(360f)
        } .start()

        binding.textView142.setOnClickListener{
            val i = Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}