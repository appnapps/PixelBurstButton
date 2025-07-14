package com.appnapps.pixelburstbutton

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appnapps.pixelburstbutton.ui.theme.PixelBurstButtonTheme

class MainActivity : ComponentActivity() {

    private lateinit var container: LinearLayout
    private var pixelBurstButton: PixelBurstButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        val pixelBurstButton = PixelBurstButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(400, 160)
        }

        rootLayout.addView(pixelBurstButton)
        setContentView(rootLayout)
    }
}