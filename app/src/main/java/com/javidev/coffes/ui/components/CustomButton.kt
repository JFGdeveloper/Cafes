package com.javidev.coffes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(label: String, modifier: Modifier = Modifier,onclick: ()->Unit ) {
    Button(
        onClick = { onclick() },
        modifier = modifier,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 4.dp,
            pressedElevation = 9.dp,
            disabledElevation = 0.dp
        )

    ) {
        Text(text = label.uppercase())
    }
}

@Preview
@Composable
fun prevCustomButton() {
    CustomButton(label = "lorem") {}
}