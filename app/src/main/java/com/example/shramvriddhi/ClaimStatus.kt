package com.example.shramvriddhi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityClaimStatusBinding


class ClaimStatus : AppCompatActivity() {
    private lateinit var binding : ActivityClaimStatusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityClaimStatusBinding.inflate(layoutInflater)
         setContentView(binding.root)


        binding.ivBackClaim.setOnClickListener {
            finish()
        }

    }
}