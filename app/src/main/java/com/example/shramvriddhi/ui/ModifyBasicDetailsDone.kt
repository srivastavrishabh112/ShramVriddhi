package com.example.shramvriddhi.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shramvriddhi.databinding.ActivityModifyBasicDetailsDoneBinding

class ModifyBasicDetailsDone : AppCompatActivity() {
    private lateinit var binding: ActivityModifyBasicDetailsDoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyBasicDetailsDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)


            binding.imageView17.animate().apply{
                duration = 1500
                rotationBy(360f)
            }.start()

        binding.textView90.setOnClickListener{
           val i = Intent(this, MainActivity::class.java).also{
               startActivity(it)
           }
            }
        }
    }
