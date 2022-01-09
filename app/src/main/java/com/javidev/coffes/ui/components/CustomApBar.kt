package com.javidev.coffes.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

typealias navigationAction= ()-> Unit

@Composable
fun CustomApBar(title:String, navigationIcon: ImageVector? = null, navigationAction: navigationAction? = null) {
    // dependiendo de las necesidades usamos uno u otro
    if (navigationIcon != null && navigationAction != null){

        AppBarConIcons(title, navigationAction,navigationIcon)
    }else{
        AppBarSinIconos(title)
    }

}




@Preview
@Composable
fun preCustom() {
    CustomApBar("lorem") {}
}

@Preview
@Composable
fun PreIcon() {
    CustomApBar("lorem", navigationIcon = Icons.Default.ArrowBack) {}
}