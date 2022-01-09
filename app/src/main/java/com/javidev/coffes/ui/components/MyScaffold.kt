package com.javidev.coffes.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.javidev.coffes.data.Origen
import com.javidev.coffes.ui.screens.DetailScreen

typealias content = @Composable ()-> Unit

@Composable
fun MyScaffold(title:String,icon: ImageVector? = null,onClick:()->Unit= {},content: content) {

    if (icon == null){
        Scaffold(
            topBar = { CustomApBar(title)},
            content = { content()}

        )
    }else{
        Scaffold(
            topBar = { CustomApBar(title = title, navigationIcon = icon, navigationAction = onClick)},
            content = {content()}
        )
    }

}