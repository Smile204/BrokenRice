package com.example.appbroken_rice.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.appbroken_rice.common.roboto_bold
import com.example.appbroken_rice.common.roboto_regular
import com.example.appbroken_rice.ui.theme.green

@Composable
fun ItemCateHome(name: String? = null, onClick: Unit? = null) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${name}",
            color = Color.White,
            fontFamily = FontFamily(roboto_bold),
            fontSize = 15.sp
        )
        TextButton(onClick = { onClick }) {
            Text(text = "see all",
                color = green,
                fontSize = 12.sp,
                fontFamily = FontFamily(roboto_regular)
            )
        }
    }
}
