package com.vishnusreddy.timerbutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.vishnusreddy.timerbutton.databinding.TimerButtonBinding

class TimerButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    var binding: TimerButtonBinding
    init {
        binding = TimerButtonBinding.inflate(LayoutInflater.from(context))
        setupViews()
    }

    private fun setupViews() {
        binding.cta
    }
}