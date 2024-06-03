package com.example.appbroken_rice.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appbroken_rice.R
import com.example.appbroken_rice.common.InputText
import com.example.appbroken_rice.common.roboto_bold
import com.example.appbroken_rice.common.roboto_regular
import com.example.appbroken_rice.helper.RetrofitAPI
import com.example.appbroken_rice.httpModal.RegisterRequestModel
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.appbroken_rice.ui.theme.color263238
import com.example.appbroken_rice.ui.theme.color303030
import com.example.appbroken_rice.ui.theme.colorC0C0C0
import com.example.appbroken_rice.ui.theme.colorFF7400

fun regis() {
    try {
        val retrofitApi = RetrofitAPI()
        val body = RegisterRequestModel(name = "", email = "", pass = "")
        retrofitApi.register(body = body, callback = {})
    } catch (e: Exception) {
        Log.d("error", "Have some error, please check your code")
    }

}

@Composable
fun RegisterScreen(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = color263238
            )
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

        var name = remember {
            mutableStateOf("")
        }
        var password = remember {
            mutableStateOf("")
        }
        var showpass = remember {
            mutableStateOf(false)
        }
        var mail = remember {
            mutableStateOf("")
        }
        InputText(
            text = name,
            onValueChange = { vl -> name.value = vl },
            placeholder = "Your name",
            img = R.drawable.user_square
        )
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
        Button(
            onClick = { navController?.navigate("Login") },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorFF7400
            )
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
