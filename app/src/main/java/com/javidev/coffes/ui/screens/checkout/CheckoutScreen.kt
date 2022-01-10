package com.javidev.coffes.ui.screens.checkout

import androidx.compose.runtime.*
import com.javidev.coffes.ui.components.CustomTextField

@Composable
fun CheckoutScreen() {
    var name by remember{ mutableStateOf("") }
    CustomTextField(value = name, placeholder = "Name"){
        name = it
    }
}