package com.javidev.coffes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialogEjem(
    modifier: Modifier = Modifier,
    visivility: Boolean,
    dissmis: ()-> Unit
) {
    if (visivility) {
        AlertDialog(
            modifier = modifier
                .background(Color.White)
                .padding(16.dp),
            onDismissRequest = {dissmis()},
            title = {
                Text(
                    text = "TERMINAR DE PAGAR?",
                    style = TextStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            text = {
                Text(
                    text = "Esta seguro que quiere pagar?",
                    style = TextStyle(
                        color = MaterialTheme.colors.surface,
                        fontSize = 16.sp
                    )
                )
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = {dissmis()}) {
                        Text(text = "Aceptar", style = MaterialTheme.typography.button)
                    }
                }
            }

        )
    }

}