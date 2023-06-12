package com.vishnusreddy.demotimerbuttonapp

import android.content.res.Resources
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vishnusreddy.demotimerbuttonapp.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}