package com.example.shramvriddhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityPassbook2Binding

class PassbookActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityPassbook2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassbook2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView16.setOnClickListener{
            val i = Intent(this,PassbookActivity3::class.java).also {
                startActivity(it)
            }
        }
        binding.textView17.setOnClickListener{
            val i = Intent(this,PassbookActivity3::class.java).also {
                startActivity(it)
            }
        }
        binding.ivBackPassbook2.setOnClickListener {
            finish()
        }

    }
}