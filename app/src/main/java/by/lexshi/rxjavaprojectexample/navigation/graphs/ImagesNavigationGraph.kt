package by.lexshi.rxjavaprojectexample.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import by.lexshi.rxjavaprojectexample.navigation.RxJavaNavigationDestination
import by.lexshi.rxjavaprojectexample.screens.images.ImagesScreen


object ImagesDestination : RxJavaNavigationDestination {
    override val route: String = "images_route"
}

object ImagesEntryDestination : RxJavaNavigationDestination {
    override val route: String = "images_entry_route"
}

fun NavGraphBuilder.imagesGraph(navController: NavHostController) {
    navigation(
        route = "${ImagesDestination.route}",
        startDestination = "${ImagesEntryDestination.route}"
    ) {
        composable(route = "${ImagesEntryDestination.route}") {
            ImagesScreen()
        }
    }
}