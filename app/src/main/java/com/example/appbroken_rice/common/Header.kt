package com.example.appbroken_rice.common

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.appbroken_rice.ui.theme.color8C9099
import com.example.appbroken_rice.ui.theme.colorFE724C


@Composable
fun HeaderCommon(
    iconLeft: Int? = null,
    iconRight: Int? = null,
    title: String? = null,
    title1: String? = null,
    icondow: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (iconLeft != null) {
            Image(
                painter = painterResource(id = iconLeft),
                contentDescription = "Left icon",
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        // Handle click event here
                    }
            )
        }
        Text(
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                title?.let {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = FontFamily(roboto_medium),
                            color = color8C9099,
                        )
                    ) {
                            append("${title}\n")
                    }
                }
                title1?.let {
                    withStyle(
                        style = SpanStyle(
                            color = colorFE724C,
                            fontFamily = FontFamily(roboto_medium)
                        )
                    ) {
                        append("${title1}")
                    }
                }
            })
        if (iconRight != null) {
            Image(
                painter = painterResource(id = iconRight),
                contentDescription = "Right icon",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {

                    }
            )
        } else {
            Box {}
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    AppBroken_riceTheme {
        HeaderCommon()
    }
}
