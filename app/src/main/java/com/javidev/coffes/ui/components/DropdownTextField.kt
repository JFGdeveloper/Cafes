package com.javidev.coffes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import kotlin.math.exp

@Composable
fun DropdownTextField(
     value: String,
     placeHolder: String,
     sugerencias: List<String>,
     onvalueChange: (String)-> Unit
) {
    var expandend by remember { mutableStateOf(false)}
    var textSize by remember { mutableStateOf(Size.Zero)}
    val icon = Icons.Filled.ArrowDropDown

    Column() {
        CustomTextField(
            value = value,
            placeholder = placeHolder,
            onValueChanged = onvalueChange,
            enabled = false,
            trainlingIcon = {
                            Icon(
                                icon,
                                contentDescription = null,
                                modifier = Modifier.clickable { expandend = !expandend }
                            )
            },
            // para que funcione el DropdownMenu
            onGloballyPositioned = { misCordinadas ->
                textSize = misCordinadas.size.toSize()
            }
        )

        DropdownMenu(
            expanded = expandend,
            onDismissRequest = { expandend = false},
            modifier = Modifier
                .width(with(LocalDensity.current) {
                    textSize.width.toDp()
                })
                .background(color = MaterialTheme.colors.secondary)
        ) {
            sugerencias.forEach { label ->
                DropdownMenuItem(onClick = {
                    onvalueChange(label)
                }) {
                    Text(text = label, style = MaterialTheme.typography.h2)
                }
            }


        }



    }


}
