@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.appbroken_rice.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavHostController? = null,
    viewModel: RegisterViewModel = viewModel()
) {
    val context = LocalContext.current

    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val showPasswordState = remember { mutableStateOf(false) }

    viewModel.registerResult = { response ->
        if (response != null) {
            // Navigate to Login screen
            navController?.navigate("Login")
        }
    }

    viewModel.registerError = { error ->
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color263238)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Create",
            fontSize = 36.sp,
            fontFamily = FontFamily(roboto_bold),
            color = Color.White,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Text(
            text = "Account",
            fontSize = 36.sp,
            fontFamily = FontFamily(roboto_bold),
            color = Color.White,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Column(modifier = Modifier.padding(start = 20.dp, end = 100.dp, top = 20.dp)) {
            Text(
                text = "Enter your Email and Password to sign ",
                fontSize = 14.sp,
                fontFamily = FontFamily(roboto_regular),
                color = colorC0C0C0
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "up.",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(roboto_regular),
                    color = colorC0C0C0
                )
                TextButton(onClick = { navController?.navigate("Login") }) {
                    Text(
                        text = "Already have an account?.",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(roboto_regular),
                        color = colorFF7400
                    )
                }
            }
        }

        Image(
            painterResource(id = R.drawable.comtam),
            contentDescription = "logo com tam",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(150.dp)
        )

        InputText(
            text = nameState,
            onValueChange = { nameState.value = it },
            placeholder = "Your name",
            img = R.drawable.user_square,
            type = true
        )

        InputText(
            text = emailState,
            onValueChange = { emailState.value = it },
            placeholder = "Email",
            img = R.drawable.key,
            type = true
        )

        InputText(
            text = passwordState,
            onValueChange = { passwordState.value = it },
            placeholder = "Password",
            img = R.drawable.key,
            type = showPasswordState.value
        )
        Button(
            onClick = {
                viewModel.register(emailState.value, passwordState.value, nameState.value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorFF7400)
        ) {
            Text(
                text = "Sign Up",
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
fun PreviewRegister() {
    AppBroken_riceTheme {
        RegisterScreen()
    }
}
