package com.javidev.coffes.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.javidev.coffes.data.Product
import com.javidev.coffes.ui.components.CustomButton


@Composable
fun InformationProduct(pais: Product, onclickCheck: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        // titulo
        Text(text = "Cafe de ${pais.origin.lowercase()}", style = MaterialTheme.typography.h3)
        // summary
        Text(text = "${pais.getSummary()}", style = MaterialTheme.typography.caption)
        Spacer(modifier = Modifier.height(8.dp))

        //body
        Text(
            text= pais.getTexto(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(16.dp))
        RowButton(pais,onclickCheck)
    }
}

@Composable
private fun RowButton(pais: Product,onclickCheck: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "${pais.getMoneda()}${pais.getPrecio()}",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.End
        )

        CustomButton(label = "Continuar", modifier = Modifier.fillMaxWidth()) {
            onclickCheck()
        }
    }
}
