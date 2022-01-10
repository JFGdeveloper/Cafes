package com.javidev.coffes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.coffes.data.Origen
import com.javidev.coffes.ui.components.CustomApBar
import com.javidev.coffes.ui.components.CustomButton
import com.javidev.coffes.ui.components.MyScaffold
import com.javidev.coffes.ui.components.navigationAction

@Composable
fun DetailScreen(pais: Origen,onclick: ()->Unit, onclickCheck: () -> Unit) {
    MyScaffold(title = pais.origin, icon = Icons.Default.ArrowBack, onClick = onclick) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id= pais.getBackgroundImage()),
                contentDescription= "imagen item ",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(400.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                // titulo
                Text(text = "Cafe de ${pais.origin}", style = MaterialTheme.typography.h3)
                // summary
                Text(text = "Alto contenido en cafeina", style = MaterialTheme.typography.caption)
                Spacer(modifier = Modifier.height(8.dp))
                
                //body
                Text(text = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.")
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)){
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
        }
    }


}

@Preview
@Composable
fun PrevDetail() {
    DetailScreen(pais = Origen.CRI, onclick = {}, onclickCheck = {})
}