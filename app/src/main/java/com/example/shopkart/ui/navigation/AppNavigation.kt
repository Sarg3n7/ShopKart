package com.example.shopkart.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopkart.ui.screens.HomeScreen
import com.example.shopkart.ui.screens.LoginScreen
import com.example.shopkart.ui.screens.ResultsScreen
import com.example.shopkart.ui.screens.SettingsScreen
import com.example.shopkart.viewmodel.AuthViewModel
import com.example.shopkart.viewmodel.HomeViewModel


object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val RESULTS = "results"
    const val SETTINGS = "settings"
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = viewModel()
) {
    val user by authViewModel.user.collectAsState()
    val homeViewModel: HomeViewModel = viewModel()

    val startDestination = if (user != null) Routes.HOME else Routes.LOGIN

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(
                authViewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen(
                homeViewModel = homeViewModel,
                onSearchClick = {
                    navController.navigate(Routes.RESULTS)
                },
                onSettingsClick = {
                    navController.navigate(Routes.SETTINGS)
                },
                onLogoutClick = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                authViewModel = authViewModel
            )
        }

        composable(Routes.RESULTS) {
            ResultsScreen(
                homeViewModel = homeViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.SETTINGS) {
            SettingsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}