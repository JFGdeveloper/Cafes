package com.javidev.coffes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.javidev.coffes.ui.Myapp
import com.javidev.coffes.ui.navigation.MyNavigation
import com.javidev.coffes.ui.screens.FedScreen
import com.javidev.coffes.ui.theme.CoffesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp{
                MyNavigation()
            }
        }
    }
}
