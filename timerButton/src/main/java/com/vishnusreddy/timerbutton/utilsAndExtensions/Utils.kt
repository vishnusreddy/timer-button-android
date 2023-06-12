package com.vishnusreddy.timerbutton.utilsAndExtensions

import android.content.Context
import android.util.TypedValue

object Utils {

    fun spToPx(context: Context, sp: Int): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, sp.toFloat(),
            context.resources.displayMetrics
        )
    }

}