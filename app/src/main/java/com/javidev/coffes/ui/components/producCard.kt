package com.javidev.coffes.ui.components

import android.webkit.WebStorage
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.javidev.coffes.R
import com.javidev.coffes.data.Origen
import com.javidev.coffes.ui.theme.CoffesTheme
import com.javidev.coffes.ui.theme.surfaceCardBlue
import org.intellij.lang.annotations.JdkConstants

@Composable
fun ProducCard(
    summary: String,
    price: Double,
    moneda: String,
    origen: Origen,
    onClick: (Origen)-> Unit
) {
    Card(modifier = Modifier
        .padding(16.dp)
        .clickable { onClick(origen) }
        .size(450.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp
    ) {

        Image(
            painter = painterResource(id = origen.getBackgroundImage()),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = origen.getSurface().copy(alpha = 0.3f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = origen.origin, style = MaterialTheme.typography.h4)
                Text(text = summary, color = Color.White)


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
                            painter = painterResource(id = origen.getFlag()),
                            contentDescription = "logo de colombia",
                            modifier = Modifier.size(32.dp),
                            alignment = Alignment.Center
                        )

                        Text(
                            text = "$price$ $moneda",
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

