package by.lexshi.rxjavaprojectexample.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import by.lexshi.rxjavaprojectexample.navigation.RxJavaNavigationDestination
import by.lexshi.rxjavaprojectexample.screens.SettingsScreen

object SettingsDestination : RxJavaNavigationDestination {
    override val route: String = "settings_route"
}

object SettingsEntryDestination : RxJavaNavigationDestination {
    override val route: String = "settings_entry_route"
}

fun NavGraphBuilder.settingsGraph(navController: NavHostController){
    navigation(
        route = "${SettingsDestination.route}",
        startDestination = "${SettingsEntryDestination.route}"
    ) {
        composable(route = "${SettingsEntryDestination.route}") {
            SettingsScreen()
        }
    }
}

