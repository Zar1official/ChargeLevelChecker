package ru.zar1official.chargelevelchecker.ui.theme.screens.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.zar1official.chargelevelchecker.ui.theme.battery.BatteryScreen
import ru.zar1official.chargelevelchecker.ui.theme.screens.about.AboutScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomBar(navController = navController)
    }) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavController) {
    BottomNavigation {
        val screens = listOf(BottomBarScreen.Battery, BottomBarScreen.About)
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = false,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        popUpTo(screen.route)
                    }
                },
                icon = { Icon(imageVector = screen.icon, contentDescription = stringResource(id = screen.contentDescription)) },
                label = { Text(text = stringResource(id = screen.title)) })
        }
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Battery.route) {
        composable(
            route = BottomBarScreen.Battery.route
        ) {
            BatteryScreen()
        }
        composable(route = BottomBarScreen.About.route) {
            AboutScreen()
        }
    }
}