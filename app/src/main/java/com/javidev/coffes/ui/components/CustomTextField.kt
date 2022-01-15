package com.javidev.coffes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    value: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    enabled: Boolean = true,
    trainlingIcon: @Composable (()->Unit)? = null,
    onGloballyPositioned: ((LayoutCoordinates)->Unit)? = null,
    onValueChanged: (String)->Unit
) {

    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(placeholder, style = MaterialTheme.typography.caption) },
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .onGloballyPositioned { cordinates ->
                if (onGloballyPositioned != null) {
                    onGloballyPositioned(cordinates)
                }
            },
        keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()}),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
        ),
        trailingIcon = trainlingIcon
    )

}