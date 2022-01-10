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
import com.javidev.coffes.ui.screens.detail.InformationProduct

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

            InformationProduct(pais, onclickCheck)
        }
    }


}

@Preview
@Composable
fun PrevDetail() {
    DetailScreen(pais = Origen.CRI, onclick = {}, onclickCheck = {})
}