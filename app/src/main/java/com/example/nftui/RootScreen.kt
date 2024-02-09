package com.example.nftui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nftui.home.HomeScreen
import com.example.nftui.onBoarding.OnBoardingScreen
import com.example.nftui.stats.StatsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RootScreen() {
    val navController = rememberNavController()
    var shouldShowOnBoardingScreen by rememberSaveable {
        mutableStateOf(true)
    }
    Scaffold(
        bottomBar = {
            if (!shouldShowOnBoardingScreen) {
                BottomBar(navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = if (!shouldShowOnBoardingScreen) NavigationItem.Home.route else NavigationItem.Login.route
        ) {
            composable(route = NavigationItem.Login.route) {
                OnBoardingScreen {
                    navController.navigate(NavigationItem.Home.route)
                    shouldShowOnBoardingScreen = false
                }
            }
            composable(route = NavigationItem.Home.route) {
                HomeScreen()
            }
            composable(route = NavigationItem.Stats.route) {
                StatsScreen()
            }
            composable(route = NavigationItem.Add.route) {
                DummyScreen(text = "Add")
            }
            composable(route = NavigationItem.Search.route) {
                DummyScreen(text = "Search")
            }
            composable(route = NavigationItem.Profile.route) {
                DummyScreen(text = "Profile")
            }
        }
    }
}

sealed class NavigationItem(val route: String, val icon: ImageVector, val title: String) {
    data object Login : NavigationItem("login", Icons.Filled.Home, "Home")
    data object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    data object Stats : NavigationItem("stats", Icons.Filled.Analytics, "Home")
    data object Add : NavigationItem("add", Icons.Filled.Add, "Home")
    data object Search : NavigationItem("search", Icons.Filled.Search, "Home")
    data object Profile : NavigationItem("profile", Icons.Filled.Person, "Home")
}

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Stats,
        NavigationItem.Add,
        NavigationItem.Search,
        NavigationItem.Profile
    )
    BottomAppBar(
        containerColor = Color(33, 17, 52),
        contentColor = Color.White
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Image(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(
                            if (currentRoute == item.route) Color.White else Color.White.copy(
                                0.4f
                            )
                        )
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                alwaysShowLabel = false,
            )
        }
    }
}

@Composable
fun DummyScreen(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewRootScreen() {
    RootScreen()
}