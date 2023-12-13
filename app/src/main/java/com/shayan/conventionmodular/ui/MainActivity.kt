package com.shayan.conventionmodular.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shayan.conventionmodular.bottomNav.RootNavHost
import com.shayan.conventionmodular.ui.theme.OkConventionModularAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OkConventionModularAppTheme {
                RootNavHost()
            }
        }
    }
}


