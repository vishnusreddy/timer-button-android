package com.vishnusreddy.demotimerbuttonapp

import android.content.res.Resources
import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import com.vishnusreddy.demotimerbuttonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cta.viewTreeObserver.addOnGlobalLayoutListener {
            binding.progressHorizontal.trackThickness = binding.cta.height
        }

        binding.progressHorizontal.setProgress(100, true)
    }

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }
}