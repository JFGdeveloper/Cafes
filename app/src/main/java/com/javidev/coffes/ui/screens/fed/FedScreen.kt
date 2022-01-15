package com.javidev.coffes.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.javidev.coffes.R
import com.javidev.coffes.data.Product
import com.javidev.coffes.ui.components.MyScaffold
import com.javidev.coffes.ui.screens.fed.ListCoffes

@Composable
fun FedScreen(onClick: (Product)->Unit) {
    val paises = remember {listOf<Product>(Product.NIC,Product.BRA,Product.COL,Product.CRI)}

    MyScaffold(title = stringResource(id = R.string.app_name)) {
        ListCoffes(paises, onClick)
    }
    
}

@Preview
@Composable
fun PrevFedScreen() {
    FedScreen(onClick = {})
}
