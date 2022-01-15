package com.javidev.coffes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.coffes.data.Product
import com.javidev.coffes.ui.components.MyScaffold
import com.javidev.coffes.ui.screens.detail.InformationProduct

@Composable
fun DetailScreen(pais: Product, onclick: ()->Unit, onclickCheck: () -> Unit) {
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

            InformationProduct(pais, onclickCheck)
        }
    }


}

@Preview
@Composable
fun PrevDetail() {
    DetailScreen(pais = Product.CRI, onclick = {}, onclickCheck = {})
}