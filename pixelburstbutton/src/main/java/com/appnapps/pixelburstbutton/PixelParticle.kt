package com.appnapps.pixelburstbutton

import android.graphics.Canvas
import android.graphics.Paint
import kotlin.random.Random

class PixelParticle(
    var x: Float,
    var y: Float,
    val color: Int
) {
    private var vx = Random.nextFloat() * 6f - 3f      // -3 ~ 3
    private var vy = Random.nextFloat() * -4f - 2f     // -2 ~ -6
    private var alpha = 255
    private val gravity = 0.3f

    fun update() {
        x += vx
        y += vy
        vy += gravity
        alpha -= 5
        if (alpha < 0) alpha = 0
    }

    fun draw(canvas: Canvas, paint: Paint) {
        paint.color = color
        paint.alpha = alpha
        canvas.drawRect(x, y, x + 4, y + 4, paint)
    }

    fun isDead(): Boolean = alpha == 0
}
