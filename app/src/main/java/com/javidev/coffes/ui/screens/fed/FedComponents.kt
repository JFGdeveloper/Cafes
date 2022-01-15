package com.javidev.coffes.ui.screens.fed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.coffes.data.Product
import com.javidev.coffes.ui.components.BodyText
import com.javidev.coffes.ui.components.ProducCard
import com.javidev.coffes.ui.components.Title

@Composable
fun ListCoffes(
    paises: List<Product>,
    onClick: (Product) -> Unit
) {
    LazyColumn {
        item {
            Encabezado()
        }
        items(paises) { origen ->
            ProducCard(
                pais = origen,
                onClick = { onClick(origen) }
            )
        }
    }
}


@Preview
@Composable
fun Encabezado() {
    Column(modifier = Modifier.padding(8.dp)) {
        Title(titulo = "BIENVENIDO")
        BodyText()
    }
}
