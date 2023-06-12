package com.vishnusreddy.timerbutton.utilsAndExtensions

import android.content.res.Resources

val Int.pxTodp: Int get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.dpToPx: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()