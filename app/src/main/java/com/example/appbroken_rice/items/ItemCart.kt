package com.example.appbroken_rice.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.appbroken_rice.R
import com.example.appbroken_rice.classes.Product
import com.example.appbroken_rice.common.roboto_bold
import com.example.appbroken_rice.common.roboto_regular
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.appbroken_rice.ui.theme.blue
import com.example.appbroken_rice.ui.theme.color8C8A9D
import com.example.appbroken_rice.ui.theme.colorFF7400
import com.example.appbroken_rice.ui.theme.green
import com.example.appbroken_rice.ui.theme.navy

@Composable
fun ItemCart(product: Product? = null) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(product?.image)
            .size(Size.ORIGINAL)
            .build()
    )
    Row(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                elevation = 10.dp,
//                shape = RoundedCornerShape(10.dp),
                ambientColor = Color.White
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painter, contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(Color.Transparent, shape = RoundedCornerShape(10.dp))
                .size(100.dp)
                .clip(RoundedCornerShape(15.dp)),
            )
        Column(
            modifier = Modifier
                .height(120.dp)
                .weight(1f)
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${product?.name}",
                        color = navy,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(roboto_bold)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.checkorange),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp),
                    )
                }
                Text(
                    text = "with backed salmon",
                    fontFamily = FontFamily(roboto_regular),
                    color = color8C8A9D,
                    fontSize = 14.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$ ${product?.price}.00",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(roboto_bold),
                    color = green
                )
                Row(
                    modifier = Modifier.wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(30.dp) // Kích thước hình tròn
                            .border(BorderStroke(1.dp, colorFF7400), shape = CircleShape) // Viền
                    ) {
                        Text(
                            text = "-",
                            color = colorFF7400,
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Default,
                            textAlign = TextAlign.Center
                        )
                    }
                    Text(
                        text = "01",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(roboto_bold),
                        color = blue,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(colorFF7400, shape = CircleShape)
                            .size(30.dp) // Kích thước hình tròn
                            .border(BorderStroke(1.dp, colorFF7400), shape = CircleShape) // Viền
                    ) {
                        Text(
                            text = "+",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Default,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemCart() {
    AppBroken_riceTheme {
        ItemCart()
    }
}