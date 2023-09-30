package com.example.shramvriddhi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityDykActicvity2Binding


class DykActicvity2 : AppCompatActivity() {
    private lateinit var binding:ActivityDykActicvity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDykActicvity2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivDyk2Cancel.setOnClickListener {
            finish()
        }
    }
}