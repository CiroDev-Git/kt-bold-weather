package com.cirodev.boldweatherapi.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.ui.theme.colorSecondary

@Composable
fun SearchInput(
    onSearch: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val searchPdv = rememberSaveable { mutableStateOf("") }
    TextField(
        value = searchPdv.value,
        onValueChange = {
            searchPdv.value = it
            onSearch(it)
        },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, stringResource(R.string.lets_search))
        },
        label = { Text(text = stringResource(R.string.lets_search)) },
        shape = RoundedCornerShape(26.5.dp),
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = colorSecondary
        )
    )
}