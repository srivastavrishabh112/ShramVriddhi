package com.example.shramvriddhi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityDyk1Binding

class DykActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityDyk1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDyk1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivDyk1Close.setOnClickListener {
            finish()
        }
    }
}