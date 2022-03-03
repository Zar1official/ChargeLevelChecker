package ru.zar1official.chargelevelchecker.ui.theme.screens.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import ru.zar1official.chargelevelchecker.R

sealed class BottomBarScreen(val route: String, @StringRes val title: Int, val icon: ImageVector, @StringRes val contentDescription: Int) {
    object Battery :
        BottomBarScreen(route = "battery", title = R.string.app_name, icon = Icons.Default.Home, contentDescription = R.string.home_description)

    object About :
        BottomBarScreen(route = "about", title = R.string.about_title, icon = Icons.Default.Info, contentDescription = R.string.about_description)
}