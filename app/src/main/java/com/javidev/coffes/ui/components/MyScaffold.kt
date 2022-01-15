package com.javidev.coffes.ui.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

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