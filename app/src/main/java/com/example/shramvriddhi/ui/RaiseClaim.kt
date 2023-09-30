package com.example.shramvriddhi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityRaiseClaimBinding

class RaiseClaim : AppCompatActivity() {
    private lateinit var binding: ActivityRaiseClaimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRaiseClaimBinding.inflate(layoutInflater)
        setContentView(binding.root)

      binding.buttonRaiseClaim.setOnClickListener{
          val i = Intent(this, RaiseClaim2::class.java).also {
              startActivity(it)
          }
      }
    }
}