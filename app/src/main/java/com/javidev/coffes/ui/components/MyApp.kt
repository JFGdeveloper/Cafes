package com.javidev.coffes.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.javidev.coffes.ui.theme.CoffesTheme

@Composable
fun Myapp(content: @Composable ()-> Unit) {
    CoffesTheme {
       Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}