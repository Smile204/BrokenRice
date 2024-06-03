package com.example.appbroken_rice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbroken_rice.navigation.BottomTab
import com.example.appbroken_rice.screens.LoginScreen
import com.example.appbroken_rice.screens.ProductDetail
import com.example.appbroken_rice.screens.RegisterScreen
import com.example.appbroken_rice.screens.SplashScreen
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme

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
        //Khai bao navigation
        val navController = rememberNavController()

        //Xay dung navigation chuyen man hinh
        NavHost(navController = navController, startDestination = "Splash") {
            composable("Splash") { SplashScreen(navController) }
            composable("Signup") { RegisterScreen(navController) }
            composable("Login"){ LoginScreen(navController) }
            composable("Home"){ BottomTab() }
            composable("ProductDetail"){ ProductDetail(navController) }
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
