package com.example.appbroken_rice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appbroken_rice.classes.Cart
import com.example.appbroken_rice.navigation.BottomTab
import com.example.appbroken_rice.screens.LoginScreen
import com.example.appbroken_rice.screens.RegisterScreen
import com.example.appbroken_rice.screens.SplashScreen
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.myapplication.screens.ProductDetail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBroken_riceTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background)
                ) {
                    Body()
                }
            }
        }
    }

    @Composable
    fun Body() {
        //Lưu thông tin giỏ hàng
        var cartInfo by remember {
            mutableStateOf(listOf<Cart>())
        }

        //Cập nhật giỏ hàng
        fun updateCart(item: Cart) {
            // kiểm tra item có trong giỏ hàng chưa
            val index = cartInfo.indexOfFirst { it.product?._id == item.product?._id }
            if (index == -1) {
                // chưa có thì thêm vào
                cartInfo = cartInfo + item
                Toast.makeText(this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show()
            } else {
                // có rồi thì cập nhật số lượng
                // nếu số lượng giảm về 0 thì xóa item đó
                if (item.quantity + cartInfo[index].quantity == 0) {
                    cartInfo = cartInfo.filterIndexed { i, _ -> i != index }
                } else {
                    cartInfo = cartInfo.mapIndexed { i, cart ->
                        if (i == index) {
                            Cart(
                                product = cart.product,
                                quantity = cart.quantity + item.quantity
                            )
                        } else {
                            cart
                        }
                    }
                }
            }
        }

        //Khai bao navigation
        val navController = rememberNavController()

        //Xay dung navigation chuyen man hinh
        NavHost(navController = navController, startDestination = "Splash") {
            composable("Splash") { SplashScreen(navController) }
            composable("Signup") { RegisterScreen(navController) }
            composable("Login"){ LoginScreen(navController) }
            composable("Home"){ BottomTab(onProductClick = { productId ->
                navController.navigate("ProductDetail/$productId")
                Log.d("------------------->", "PRODUCT ID >>>>>: $productId")
            }) }
            composable("ProductDetail/{value}",
                arguments = listOf(navArgument("value") { defaultValue = "0" })){navBackStackEntry ->
                ProductDetail(navController,
                    value = navBackStackEntry.arguments?.getString("value") ?: "0",
                    updateCart = { updateCart(it) }) }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        AppBroken_riceTheme {
            Body()
        }
    }
}
