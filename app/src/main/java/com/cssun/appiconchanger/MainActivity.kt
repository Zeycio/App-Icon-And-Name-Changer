package com.cssun.appiconchanger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cssun.appiconchanger.ui.screen.MainScreen
import com.cssun.appiconchanger.ui.theme.AppIconChangerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppIconChangerTheme {
                MainScreen(context = this)
            }
        }
    }
}


