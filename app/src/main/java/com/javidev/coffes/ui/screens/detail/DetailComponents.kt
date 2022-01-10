package com.javidev.coffes.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.javidev.coffes.data.Origen
import com.javidev.coffes.ui.components.CustomButton


@Composable
fun InformationProduct(pais: Origen, onclickCheck: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        // titulo
        Text(text = "Cafe de ${pais.origin}", style = MaterialTheme.typography.h3)
        // summary
        Text(text = "Alto contenido en cafeina", style = MaterialTheme.typography.caption)
        Spacer(modifier = Modifier.height(8.dp))

        //body
        Text(
            text = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.",
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(16.dp))
        RowButton(onclickCheck)
    }
}

@Composable
private fun RowButton(onclickCheck: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "$ 35.0 USD",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.End
        )

        CustomButton(label = "Continuar") {
            onclickCheck()
        }
    }
}
