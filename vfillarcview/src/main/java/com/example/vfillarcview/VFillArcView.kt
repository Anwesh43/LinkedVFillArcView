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


fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawVFillArc(scale : Float, w  : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    save()
    translate(w / 2, h / 2)
    for (j in 0..1) {
        save()
        rotate((deg / 2) * (1f - 2 * j))
        drawLine(0f, 0f, size * sf1 * (1f - 2 * j), 0f, paint)
        restore()
    }
    drawArc(RectF(-size, -size, size, size), -45f, 270f * sf2, true, paint)
    restore()
}

fun Canvas.drawVFANode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawVFillArc(scale, w, h, paint)
}

class VFillArcView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}