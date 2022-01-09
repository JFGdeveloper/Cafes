package com.javidev.coffes.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppBarSinIconos(title: String) {
    TopAppBar(
        title = { Text(title) },
        backgroundColor = MaterialTheme.colors.primary
    )
}


@Composable
fun AppBarConIcons(
    title: String,
    navigationAction: navigationAction,
    icon: ImageVector

) {
    TopAppBar(
        title = { Text(title) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = { navigationAction() }) {
                Icon(icon, contentDescription = "ArrowBack")
            }
        }

    )
}