package com.javidev.coffes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.javidev.coffes.data.Origen
import com.javidev.coffes.ui.components.CustomApBar
import com.javidev.coffes.ui.components.MyScaffold
import com.javidev.coffes.ui.components.navigationAction

@Composable
fun DetailScreen(pais: Origen,onclick: ()->Unit) {
    MyScaffold(title = pais.origin, icon = Icons.Default.ArrowBack, onClick = onclick) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ESTE PRODUCTO ES ORIGINAL DE ${pais.origin}", textAlign = TextAlign.Center )
            Button(onClick = { onclick() }) {
                Text(text = "popUpTo")
            }
        }
    }


}