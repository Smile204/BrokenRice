package com.example.appbroken_rice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appbroken_rice.R
import com.example.appbroken_rice.common.InputText
import com.example.appbroken_rice.common.roboto_bold
import com.example.appbroken_rice.common.roboto_regular
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.appbroken_rice.ui.theme.blue
import com.example.appbroken_rice.ui.theme.color263238
import com.example.appbroken_rice.ui.theme.colorC0C0C0
import com.example.appbroken_rice.ui.theme.colorFF7400

@Composable
fun LoginScreen(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = color263238
            )
            .paint(
                painter = painterResource(id = R.drawable.bg_signin),
                contentScale = ContentScale.Crop
            )
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

        val password = remember {
            mutableStateOf("")
        }
        val showpass = remember {
            mutableStateOf(false)
        }
        val mail = remember {
            mutableStateOf("")
        }
        InputText(
            text = mail,
            onValueChange = { vl -> mail.value = vl },
            placeholder = "Email",
            img = R.drawable.sms
        )
        InputText(
            text = password,
            onValueChange = { vl -> password.value = vl },
            placeholder = "Password",
            img = R.drawable.key,
            type = showpass.value
        )
        Text(
            text = "Forgot Password ? ", modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(top = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = blue,
            fontSize = 13.sp,
            fontFamily = FontFamily(roboto_regular)
        )
        Button(
            onClick = { navController?.navigate("Home") },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorFF7400
            )
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