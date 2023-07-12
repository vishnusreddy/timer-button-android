package com.vishnusreddy.timerbutton

import android.animation.ObjectAnimator
import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getColor
import com.vishnusreddy.timerbutton.databinding.TimerButtonBinding
import com.vishnusreddy.timerbutton.utilsAndExtensions.Utils.spToPx
import com.vishnusreddy.timerbutton.utilsAndExtensions.dpToPx

class TimerButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.timerButtonStyle,
) : ConstraintLayout(context, attrs) {

    var binding: TimerButtonBinding

    /** View attributes global variables. */
    private var text: CharSequence? = null
    private var textColor: Int = getColor(context, R.color.md_grey_50)
    private var textSize: Float = spToPx(context, 17f)
    private var progressColor: Int = getColor(context, R.color.md_grey_400)
    private var trackColor: Int = getColor(context, R.color.md_grey_300)
    private var buttonColor: Int = getColor(context, R.color.md_grey_300)
    private var cornerRadius: Int = 8.dpToPx
    private var progressPercentage = 0f


    init {
        binding = TimerButtonBinding.inflate(LayoutInflater.from(context), this, true)
        getAttributes(attrs, defStyleAttr)
        setupViews()
    }

    /** If attributes are not present, we will be making use of the default attributes as mentioned below. */
    private fun getAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val attributes =
            context.theme.obtainStyledAttributes(attrs, R.styleable.TimerButton, defStyleAttr, 0)

        // Text Attributes
        text = attributes.getText(R.styleable.TimerButton_text)
        textColor = attributes.getColor(
            R.styleable.TimerButton_textColor, getColor(context, R.color.md_grey_50)
        )
        textSize = attributes.getDimension(R.styleable.TimerButton_textSize, spToPx(context, 17F))

        // Progress, Track and Button Attributes
        progressColor = attributes.getColor(
            R.styleable.TimerButton_textColor, getColor(context, R.color.md_grey_400)
        )
        trackColor = attributes.getColor(
            R.styleable.TimerButton_textColor, getColor(context, R.color.md_grey_300)
        )
        buttonColor = attributes.getColor(
            R.styleable.TimerButton_textColor, getColor(context, R.color.md_grey_300)
        )
        cornerRadius = attributes.getDimension(
            R.styleable.TimerButton_cornerRadius, 8F
        ).toInt().dpToPx

        // Percentage of Progress Completed
        progressPercentage = attributes.getFloat(R.styleable.TimerButton_progressPercentage, 0f)

        attributes.recycle()
    }

    private fun setupViews() {
        binding.cta.viewTreeObserver.addOnGlobalLayoutListener {
            binding.progressHorizontal.trackThickness = binding.cta.height
        }

        binding.tvTitle.text = text
        binding.tvTitle.setTextColor(textColor)
        binding.tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)

        binding.progressHorizontal.setIndicatorColor(progressColor)
        binding.progressHorizontal.trackColor = trackColor

        binding.cta.setBackgroundColor(buttonColor)

        binding.progressHorizontal.trackCornerRadius = cornerRadius
        binding.cta.cornerRadius = cornerRadius

        binding.root.visibility = View.VISIBLE
        throughCountDownTimer()

        Log.i("Came Here", "$progressPercentage")
    }

    private fun throughCountDownTimer() {
        val countDownTimer = object : CountDownTimer(120000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = ((120000 - millisUntilFinished) * 100 / 120000).toInt()
                binding.progressHorizontal.setProgress(progress, true)
            }

            override fun onFinish() {
                binding.progressHorizontal.setProgress(100, true)
            }
        }
        countDownTimer.start()
    }

    override fun onViewRemoved(view: View?) {
        super.onViewRemoved(view)
    }
}