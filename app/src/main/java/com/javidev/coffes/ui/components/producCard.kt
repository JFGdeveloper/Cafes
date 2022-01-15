package com.javidev.coffes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.coffes.data.Product

@Composable
fun ProducCard(
    pais: Product,
    onClick: (Product)-> Unit
) {
    Card(modifier = Modifier
        .padding(16.dp)
        .clickable { onClick(pais) }
        .size(450.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp
    ) {

        Image(
            painter = painterResource(id = pais.getBackgroundImage()),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = pais.getSurface().copy(alpha = 0.3f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = pais.origin, style = MaterialTheme.typography.h4)
                Text(text = pais.getSummary(), color = Color.White)


                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = pais.getFlag()),
                            contentDescription = "logo de colombia",
                            modifier = Modifier.size(32.dp),
                            alignment = Alignment.Center
                        )

                        Text(
                            text = "${pais.getPrecio()} ${pais.getMoneda()}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4
                        )
                    }

                }
            }

        }

    }
}


@Preview
@Composable
fun PrevCard() {
    ProducCard(pais = Product.NIC,  onClick = {})
}

