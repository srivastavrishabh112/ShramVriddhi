package com.example.shramvriddhi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityPassbook3Binding


class PassbookActivity3 : AppCompatActivity() {
    private lateinit var binding:ActivityPassbook3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPassbook3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackPassbook3.setOnClickListener {
            finish()
        }
    }
}