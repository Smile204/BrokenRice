package com.example.appbroken_rice.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.appbroken_rice.R
import com.example.appbroken_rice.common.roboto_bold
import com.example.appbroken_rice.common.roboto_regular
import com.example.appbroken_rice.common.roboto_thinintalic
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.appbroken_rice.ui.theme.color7E8392
import com.example.appbroken_rice.ui.theme.color8A8E9B
import com.example.appbroken_rice.ui.theme.color9796A1
import com.example.appbroken_rice.ui.theme.colorF6F6F6
import com.example.myapplication.http_model.Product


@Composable
fun ItemProductHome(product: Product?=null, onClick: () -> Unit = {}) {
    val firstimage = product?.images?.firstOrNull()
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(firstimage ?: R.drawable.bacha)
            .size(Size.ORIGINAL)
            .build()
    )
    Column(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .fillMaxWidth()
//            .padding(vertical = 16.dp)
            .padding(end = 20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(10.dp),
                // Màu đổ bóng
                ambientColor = Color.White,
                // Màu đổ bóng
                spotColor = Color.White
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .paint(
                    painter = painter,
                    contentScale = ContentScale.FillWidth
                )
                .clip(
                    RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                )
                .padding(horizontal = 15.dp, vertical = 10.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(horizontal = 7.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "4.5", modifier = Modifier.padding(end = 5.dp),
                        fontFamily = FontFamily(roboto_thinintalic),
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                    Image(
                        painterResource(id = R.drawable.star),
                        contentDescription = "star",
                        modifier = Modifier.size(17.dp)
                    )
                    Text(
                        text = "(25+)",
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .padding(start = 5.dp),
                        fontFamily = FontFamily(roboto_regular),
                        fontSize = 8.sp,
                        color = color9796A1
                    )
                }
                Box(modifier = Modifier.width(130.dp))
                Image(
                    painterResource(id = R.drawable.favorite),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White
                )
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${product?.name}", fontFamily = FontFamily(roboto_bold),
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Image(
                        painterResource(id = R.drawable.tick), contentDescription = "",
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .size(15.dp)
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    )
                    .padding(top = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Image(
                        painterResource(id = R.drawable.delivery),
                        contentDescription = "Shipping",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Free Shipping",
                        fontFamily = FontFamily(roboto_regular),
                        fontSize = 12.sp,
                        color = color7E8392
                    )
                }
                Spacer(modifier = Modifier.width(25.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.time),
                        contentDescription = "Shipping",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "10-15 mins",
                        fontFamily = FontFamily(roboto_regular),
                        fontSize = 12.sp,
                        color = color7E8392
                    )
                }
            }
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Text(
                    text = "BURGER", fontFamily = FontFamily(roboto_regular),
                    color = color8A8E9B,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(colorF6F6F6)
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "CHICKEN", fontFamily = FontFamily(roboto_regular),
                    color = color8A8E9B,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(colorF6F6F6)
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "FAST FOOD", fontFamily = FontFamily(roboto_regular),
                    color = color8A8E9B,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(colorF6F6F6)
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemProductHome(){
    AppBroken_riceTheme {
        ItemProductHome()
    }
}
