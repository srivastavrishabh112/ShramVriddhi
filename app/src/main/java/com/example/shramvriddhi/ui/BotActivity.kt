package com.example.shramvriddhi.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.shramvriddhi.R
import com.example.shramvriddhi.databinding.ActivityBotBinding

class BotActivity : AppCompatActivity() {
    private lateinit var binding:ActivityBotBinding
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myWebView: WebView = findViewById(R.id.webView)
        val webSettings = myWebView.settings
        webSettings.javaScriptEnabled = true
        myWebView.loadUrl("https://siddharth3008.github.io/ChatBot/")
    }
}