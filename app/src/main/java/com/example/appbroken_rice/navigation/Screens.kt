package com.example.appbroken_rice.navigation


sealed class Screens(val screen:String){
    data object Home: Screens("home")
    data object Favorite: Screens("favorite")
    data object Address: Screens("address")
    data object Store: Screens("store")
    data object Cart: Screens("cart")

}