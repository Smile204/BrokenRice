package com.example.appbroken_rice.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.appbroken_rice.ui.theme.color303030
import com.example.appbroken_rice.ui.theme.colorC0C0C0

@Composable
fun InputText(
    placeholder: String,
    text: MutableState<String>,
    onValueChange: (String) -> Unit,
    img: Int? = null,
    type: Boolean? = null
) {
    TextField(
        value = text.value, // <-- Corrected line
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = colorC0C0C0
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .background(color = color303030)
            .clip(
                shape = RoundedCornerShape(15.dp)
            ),
        trailingIcon = {
            Image(
                painterResource(id = img!!),
                contentDescription = "arrow right",
                modifier = Modifier.size(35.dp)
            )
        },
        visualTransformation = if (type == true) VisualTransformation.None else PasswordVisualTransformation(),
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Password
//        )
    )
}