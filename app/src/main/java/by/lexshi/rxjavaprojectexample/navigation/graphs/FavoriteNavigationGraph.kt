package by.lexshi.rxjavaprojectexample.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import by.lexshi.rxjavaprojectexample.navigation.RxJavaNavigationDestination
import by.lexshi.rxjavaprojectexample.screens.FavoriteScreen


object FavoriteImagesDestination : RxJavaNavigationDestination {
    override val route: String = "favorite_route"
}

object FavoriteImagesEntryDestination : RxJavaNavigationDestination {
    override val route: String = "favorite_entry_route"
}

fun NavGraphBuilder.favoriteImagesGraph(navController: NavHostController) {
    navigation(
        route = "${FavoriteImagesDestination.route}",
        startDestination = "${FavoriteImagesEntryDestination.route}"
    ) {
        composable(route = "${FavoriteImagesEntryDestination.route}") {
            FavoriteScreen()
        }
    }
}