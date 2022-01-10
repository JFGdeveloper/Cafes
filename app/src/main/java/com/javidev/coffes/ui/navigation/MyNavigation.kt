package com.javidev.coffes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.javidev.coffes.data.Origen
import com.javidev.coffes.ui.screens.DetailScreen
import com.javidev.coffes.ui.screens.FedScreen
import com.javidev.coffes.ui.screens.checkout.CheckoutScreen

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "fedScreen") {

        // MAIN LISTADO
        composable("fedScreen") {
            FedScreen {
                // onclick
                navController.navigate("detail/${it}") {
                    launchSingleTop = true // si ya esta creada no la vuelve a crear
                }
            }
        }

        // DETALLE DEL ITEM
        composable("detail/{mierda}") { backStackEntry ->
            val origen = backStackEntry.arguments?.getString("mierda") ?: "defaul"
            // lo converimos a objeto origen
            val objOrigen = Origen.valueOf(origen)
            DetailScreen(
                pais = objOrigen,
                onclick = {
                    // ONCLICK
                    navController.navigate("fedScreen") {
                        popUpTo("fedScreen") // este metodo vuelve al activity del que venimos sin crear uno nuevo
                    }
                },
                onclickCheck = {
                    navController.navigate("checkout"){
                        launchSingleTop = true
                        popUpTo("detail")
                    }
                }
            )
        }

        // CHECKOUT SCREEN
        composable("checkout"){
            CheckoutScreen()
        }



    }

}