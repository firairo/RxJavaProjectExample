package by.lexshi.rxjavaprojectexample.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import by.lexshi.rxjavaprojectexample.navigation.RxJavaNavHost
import by.lexshi.rxjavaprojectexample.navigation.graphs.TOP_LEVEL_DESTINATIONS
import by.lexshi.rxjavaprojectexample.navigation.graphs.TopLevelDestination
import by.lexshi.rxjavaprojectexample.navigation.graphs.TopLevelNavigation
import by.lexshi.rxjavaprojectexample.screens.bottomBarCurrentVisibility

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RxJavaStartScreen() {
    val navController = rememberNavController()
    val topLevelNavigation = remember(navController) {
        TopLevelNavigation(navController)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier,
        containerColor = Color.Gray,
        contentColor = Color.Transparent,
        bottomBar = {
            if (currentDestination != null && bottomBarCurrentVisibility()) {
                BottomBar(
                    currentDestination = currentDestination,
                    onNavigateToTopLevelDestination = topLevelNavigation::navigateTo
                )
            }
        }
    ) { paddingValues ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
                )
        ) {
            RxJavaNavHost(
                navController = navController,
                modifier = Modifier.consumedWindowInsets(paddingValues)
            )
        }
    }
}

@Composable
fun BottomBar(
    currentDestination: NavDestination,
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.White, RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .padding(horizontal = 12.dp)
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TOP_LEVEL_DESTINATIONS.forEach { destination ->
            NavigationBarItem(
                label = {
                    Text(
                        text = destination.route,
                        color = if (currentDestination.hierarchy.any { it.route == destination.route }) Color.Black else Color.Blue
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(destination.iconId),
                        contentDescription = null
                    )
                },
                selected = currentDestination.hierarchy.any { it.route == destination.route },
                onClick = { onNavigateToTopLevelDestination(destination) }
            )
        }
    }
}

