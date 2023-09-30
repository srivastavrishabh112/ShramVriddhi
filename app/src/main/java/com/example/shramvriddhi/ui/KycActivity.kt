package com.example.shramvriddhi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.shramvriddhi.databinding.ActivityKycBinding

class KycActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKycBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKycBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView130.setOnClickListener{
            binding.clSecond.visibility = View.INVISIBLE
           binding.clFirst.visibility = View.VISIBLE
        }

        binding.textView110.setOnClickListener{
            binding.clFirst.visibility = View.INVISIBLE
            binding.clSecond.visibility = View.VISIBLE
        }

        binding.textView122.setOnClickListener{
            binding.clFourth.visibility= View.VISIBLE
        }
        binding.imageView32.setOnClickListener {
           binding.clFourth.visibility = View.INVISIBLE
        }

        binding.textView124.setOnClickListener{
            binding.clFourth.visibility= View.VISIBLE
        }

        binding.imageView34.setOnClickListener {
            binding.clFourth.visibility = View.INVISIBLE
        }

    }
}