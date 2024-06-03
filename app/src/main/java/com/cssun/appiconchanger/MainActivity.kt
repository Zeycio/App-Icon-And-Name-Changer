package com.cssun.appiconchanger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cssun.appiconchanger.ui.screen.MainScreen
import com.cssun.appiconchanger.ui.theme.AppIconChangerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppIconChangerTheme {
                MainScreen(context = this)
            }
        }
    }
}


