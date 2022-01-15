package com.javidev.coffes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javidev.coffes.data.Product
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
        composable("detail/{id}") { backStackEntry ->
            val origen = backStackEntry.arguments?.getString("id") ?: "defaul"
            // lo converimos a objeto origen
            val objOrigen = Product.valueOf(origen)
            DetailScreen(
                pais = objOrigen,
                onclick = {
                    // ONCLICK
                    navController.navigate("fedScreen") {
                        popUpTo("fedScreen") // este metodo vuelve al activity del que venimos sin crear uno nuevo
                    }
                },
                onclickCheck = {
                    navController.navigate("checkout/${objOrigen}"){
                        //launchSingleTop = true
                        popUpTo("detail")
                    }
                }
            )
        }

        // CHECKOUT SCREEN
        composable("checkout/{origin}"){
            val origen = it.arguments?.getString("origin") ?: "defaul"
            // lo converimos a objeto origen
            val objOrigen = Product.valueOf(origen)
            CheckoutScreen(objOrigen){
                navController.navigate("detail/${objOrigen}"){
                    popUpTo("detail")
                }
            }
        }



    }

}