package com.javidev.coffes.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Title(titulo: String) {
    Text(text = titulo, style = MaterialTheme.typography.h3)
}