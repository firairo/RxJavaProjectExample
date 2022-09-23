package by.lexshi.rxjavaprojectexample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import by.lexshi.rxjavaprojectexample.navigation.graphs.ImagesDestination
import by.lexshi.rxjavaprojectexample.navigation.graphs.authNavGraph
import by.lexshi.rxjavaprojectexample.navigation.graphs.favoriteImagesGraph
import by.lexshi.rxjavaprojectexample.navigation.graphs.imagesGraph
import by.lexshi.rxjavaprojectexample.navigation.graphs.settingsGraph

@Composable
fun RxJavaNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "${ImagesDestination.route}",
        modifier = modifier
    ) {

        //auth navigation
        authNavGraph(navController)

        //top bottom navigation
        imagesGraph(navController)
        favoriteImagesGraph(navController)
        settingsGraph(navController)
    }
}