package com.example.vfillarcview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Color
import android.graphics.RectF
import android.graphics.Canvas
import android.app.Activity
import android.content.Context

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#9C27B0",
    "#00C853",
    "#BF360C",
    "#3F51B5"
).map {
    Color.parseColor(it)
}.toTypedArray()
val delay : Long = 20
val strokeFactor : Float = 90f
val sizeFactor : Float = 2.9f
val parts : Int = 3
val deg : Float = 90f
val scGap : Float = 0.02f / parts