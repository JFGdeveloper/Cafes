package com.javidev.coffes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javidev.coffes.data.Product
import com.javidev.coffes.ui.components.DialogEjem
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
                    //launchSingleTop = true // si ya esta creada no la vuelve a crear
                    popUpTo("fedScreen")

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
                    // ONCLICK APPBAR
                    navController.navigate("fedScreen") {

                        // este metodo muestra la pantalla que esta mas arriba o la ultima creada del nombre que le paso
                        popUpTo("fedScreen") {inclusive = true}

                    }
                },
                // ONCLICK BOTON CHECKOUT
                onclickCheck = {
                    navController.navigate("checkout/${objOrigen}") {

                        // este metodo muestra la pantalla que esta mas arriba o la ultima creada del nombre que le paso
                        popUpTo("detail")
                    }
                }
            )
        }

        // CHECKOUT SCREEN
        composable("checkout/{origin}") {
            val origen = it.arguments?.getString("origin") ?: "defaul"
            // lo converimos a objeto origen
            val objOrigen = Product.valueOf(origen)
            CheckoutScreen(
                objOrigen,
                onclick = {
                    navController.navigate("detail/${objOrigen}") {
                        popUpTo("fedScreen")

                    }
                }
            )
        }


    }

}