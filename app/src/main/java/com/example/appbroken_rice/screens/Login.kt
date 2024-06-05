package com.example.appbroken_rice.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appbroken_rice.R
import com.example.appbroken_rice.common.InputText
import com.example.appbroken_rice.common.roboto_bold
import com.example.appbroken_rice.common.roboto_regular
import com.example.appbroken_rice.ui.theme.*

@Composable
fun LoginScreen(navController: NavHostController? = null, viewModel: LoginViewModel = viewModel()) {
    val context = LocalContext.current

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val showPasswordState = remember { mutableStateOf(false) }

    viewModel.loginResult = { response ->
        if (response != null) {
            // Navigate to Home screen
            navController?.navigate("Home")
        }
    }

    viewModel.loginError = { error ->
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color263238)
            .paint(painter = painterResource(id = R.drawable.bg_signin), contentScale = ContentScale.Crop)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Well hello",
            fontSize = 36.sp,
            fontFamily = FontFamily(roboto_bold),
            color = Color.White,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Text(
            text = "there !",
            fontSize = 36.sp,
            fontFamily = FontFamily(roboto_bold),
            color = Color.White,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Column(modifier = Modifier.padding(start = 20.dp, end = 100.dp, top = 20.dp)) {
            Text(
                text = "Enter your Email and Password to",
                fontSize = 14.sp,
                fontFamily = FontFamily(roboto_regular),
                color = colorC0C0C0
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "login, or",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(roboto_regular),
                    color = colorC0C0C0
                )
                TextButton(onClick = { navController?.navigate("Signup") }) {
                    Text(
                        text = "Create new account.",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(roboto_regular),
                        color = colorFF7400
                    )
                }
            }
        }

        InputText(
            text = emailState,
            onValueChange = { emailState.value = it },
            placeholder = "Email",
            img = R.drawable.sms,
            type = true
        )
        InputText(
            text = passwordState,
            onValueChange = { passwordState.value = it },
            placeholder = "Password",
            img = R.drawable.key,
            type = showPasswordState.value
        )
        Text(
            text = "Forgot Password ? ",
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = blue,
            fontSize = 13.sp,
            fontFamily = FontFamily(roboto_regular)
        )
        Button(
            onClick = {
                viewModel.login(emailState.value, passwordState.value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorFF7400)
        ) {
            Text(
                text = "Sign In",
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily(roboto_bold),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    AppBroken_riceTheme {
        LoginScreen()
    }
}
