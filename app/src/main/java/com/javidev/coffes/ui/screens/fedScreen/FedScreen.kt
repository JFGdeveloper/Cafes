package com.javidev.coffes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.coffes.R
import com.javidev.coffes.data.Origen
import com.javidev.coffes.ui.components.BodyText
import com.javidev.coffes.ui.components.MyScaffold
import com.javidev.coffes.ui.components.ProducCard
import com.javidev.coffes.ui.components.Title
import com.javidev.coffes.ui.screens.fedScreen.ListCoffes
import com.javidev.coffes.ui.theme.CoffesTheme

@Composable
fun FedScreen(onClick: (Origen)->Unit) {
    val paises = remember {listOf<Origen>(Origen.NIC,Origen.BRA,Origen.COL,Origen.CRI)}

    MyScaffold(title = stringResource(id = R.string.app_name)) {
        ListCoffes(paises, onClick)
    }
    
}

@Preview
@Composable
fun PrevFedScreen() {
    FedScreen(onClick = {})
}
