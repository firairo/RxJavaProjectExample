package by.lexshi.rxjavaprojectexample.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import by.lexshi.rxjavaprojectexample.navigation.RxJavaNavigationDestination
import by.lexshi.rxjavaprojectexample.screens.LoginScreen


object AuthenticationDestination : RxJavaNavigationDestination {
    override val route: String = "authentication_route"
}

object LoginDestination : RxJavaNavigationDestination {
    override val route: String = "login_route"
}

object SignUpDestination : RxJavaNavigationDestination {
    override val route: String = "sign_up_route"
}

object ForgotDestination : RxJavaNavigationDestination {
    override val route: String = "forgot_route"
}

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = "${AuthenticationDestination.route}",
        startDestination = "${LoginDestination.route}"
    ) {
        composable(
            route = "${LoginDestination.route}",
        ) {
            LoginScreen(openImagesScreen = { navController.navigate("${ImagesDestination.route}") })
        }
    }
}