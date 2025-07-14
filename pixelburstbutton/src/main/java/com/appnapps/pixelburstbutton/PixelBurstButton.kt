package com.appnapps.pixelburstbutton

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.roundToInt

class PixelBurstButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var buttonBitmap: Bitmap? = null
    private val pixelParticles = mutableListOf<PixelParticle>()
    private var isExploding = false

    private val particlePaint = Paint()
    private val updateRunnable = Runnable { updateParticles() }

    init {
        setOnClickListener {
            if (!isExploding) explode()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (isExploding) {
            pixelParticles.forEach { it.draw(canvas, particlePaint) }
        } else {
            drawButton(canvas)
        }
    }

    private fun drawButton(canvas: Canvas) {
        if (buttonBitmap == null) {
            buttonBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val tempCanvas = Canvas(buttonBitmap!!)
            val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                color = Color.BLUE
            }
            tempCanvas.drawRoundRect(
                0f, 0f,
                width.toFloat(), height.toFloat(),
                24f, 24f, paint
            )

            paint.color = Color.WHITE
            paint.textAlign = Paint.Align.CENTER
            paint.textSize = height / 3f
            tempCanvas.drawText(
                "BOOM",
                width / 2f,
                height / 2f + height / 6f,
                paint
            )
        }

        canvas.drawBitmap(buttonBitmap!!, 0f, 0f, null)
    }

    private fun explode() {
        isExploding = true
        val bmp = buttonBitmap ?: return
        pixelParticles.clear()

        // 픽셀 분해
        for (x in 0 until bmp.width step 4) {
            for (y in 0 until bmp.height step 4) {
                val pixel = bmp.getPixel(x, y)
                if (Color.alpha(pixel) != 0) {
                    pixelParticles.add(PixelParticle(x.toFloat(), y.toFloat(), pixel))
                }
            }
        }

        post(updateRunnable)
    }

    private fun updateParticles() {
        pixelParticles.forEach { it.update() }
        pixelParticles.removeAll { it.isDead() }

        if (pixelParticles.isEmpty()) {
            // 애니메이션 종료 후 원래 버튼 복구
            isExploding = false
            buttonBitmap = null
            invalidate()
        } else {
            invalidate()
            postDelayed(updateRunnable, 16) // 약 60 FPS
        }
    }
}
