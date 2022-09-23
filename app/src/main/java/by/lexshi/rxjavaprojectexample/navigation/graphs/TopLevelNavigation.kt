package by.lexshi.rxjavaprojectexample.navigation.graphs

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import by.lexshi.rxjavaprojectexample.R

class TopLevelNavigation(private val navController: NavHostController) {

    fun navigateTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

data class TopLevelDestination(
    val route: String,
    @DrawableRes
    val iconId: Int,
    @StringRes
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = ImagesDestination.route,
        iconId = R.drawable.ic_photo_24,
        iconTextId = R.string.images
    ),
    TopLevelDestination(
        route = FavoriteImagesDestination.route,
        iconId = R.drawable.ic_person_24,
        iconTextId = R.string.favorite_images
    ),
    TopLevelDestination(
        route = SettingsDestination.route,
        iconId = R.drawable.ic_settings_24,
        iconTextId = R.string.settings
    )
)
