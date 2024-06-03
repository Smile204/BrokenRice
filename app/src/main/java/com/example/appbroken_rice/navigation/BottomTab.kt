package com.example.appbroken_rice.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbroken_rice.R

@Composable
fun BottomTab(){
    val navController = rememberNavController()
    val select = remember {
        mutableStateOf("home")
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.background
            ) {
                IconButton(
                    onClick = {
                        select.value = "home"
                        navController.navigate(Screens.Home.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = if (select.value == "home") {
                            painterResource(id = R.drawable.homes)
                        } else {
                            painterResource(id = R.drawable.home)
                        },
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                    )
                }

                IconButton(
                    onClick = {
                        select.value = "favorite"
                        navController.navigate(Screens.Favorite.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = if (select.value == "favorite") {
                            painterResource(id = R.drawable.hearts)
                        } else {
                            painterResource(id = R.drawable.heart)
                        },
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                    )
                }


                IconButton(
                    onClick = {
                        select.value = "address"
                        navController.navigate(Screens.Address.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = if (select.value == "address") {
                            painterResource(id = R.drawable.locations)
                        } else {
                            painterResource(id = R.drawable.location)
                        },
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                    )
                }

                IconButton(
                    onClick = {
                        select.value = "store"
                        navController.navigate(Screens.Store.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = if (select.value == "store") {
                            painterResource(id = R.drawable.stores)
                        } else {
                            painterResource(id = R.drawable.storee)
                        },
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                    )
                }

                IconButton(
                    onClick = {
                        select.value = "cart"
                        navController.navigate(Screens.Cart.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = if (select.value == "cart") {
                            painterResource(id = R.drawable.shops)
                        } else {
                            painterResource(id = R.drawable.shop)
                        },
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                    )
                }
            }
        }) {
        val padding = it
        NavHost(
            navController = navController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(padding)
        ) {
            composable("Home") { MainHome() }
            composable("Favorite") { FavoriteScreen() }
            composable("Address") { AddressScreen() }
            composable("Store") { StoreScreen() }
            composable("Cart") { CartScreen() }
        }
    }
}