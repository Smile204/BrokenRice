package com.example.appbroken_rice.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appbroken_rice.R
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.appbroken_rice.ui.theme.Orange
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController? = null) {
    //Set thời gian bị trễ
    var timerFinished by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = timerFinished) {
        delay(2000)
        timerFinished = true
    }

    if (timerFinished) {
        navController?.navigate("Login")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Orange),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_comtam),
            contentDescription = "Logo Broken Rice",
            modifier = Modifier
                .width(215.dp)
                .height(227.dp),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSplash() {
    AppBroken_riceTheme {
        SplashScreen()
    }

}
