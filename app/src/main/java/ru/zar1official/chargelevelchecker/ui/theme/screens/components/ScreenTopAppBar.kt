package ru.zar1official.chargelevelchecker.ui.theme.screens.components

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ScreenTopAppBar(@StringRes titleResource: Int) {
    TopAppBar(elevation = 5.dp) {
        Text(text = stringResource(id = titleResource))
    }
}