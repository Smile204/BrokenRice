package com.example.myapplication.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.appbroken_rice.R
import com.example.appbroken_rice.classes.Cart
import com.example.appbroken_rice.ui.theme.color303030
import com.example.myapplication.helper.RetrofitAPI
import com.example.myapplication.http_model.ProductDetail
import com.example.myapplication.http_model.ProductDetailResponse


@Composable
fun ProductDetail(navController: NavController? = null,
                  value: String? = null, updateCart: (Cart) -> Unit = {}) {
    val context = LocalContext.current
    var productDetail by remember {
        mutableStateOf(ProductDetail(null, null, null, null, null, null, null, null, null, null))
    }

    fun getProductCallBack(response: ProductDetailResponse?) {
        if (response != null) {
            productDetail = response.data
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            Log.d("------------->data ", "${productDetail}")
        }
    }

    fun getProductDetail() {
        val reTrofitAPI = RetrofitAPI()
        try {
            reTrofitAPI.getProductDetail(value, callback = { getProductCallBack(it) })
        } catch (e: Exception) {
            Toast.makeText(context, "Loi: ${e.message}", Toast.LENGTH_SHORT).show()
            Log.e("Error-------------------->>>>>", "Loi-------> ${e.message}")
        }
    }

    getProductDetail()

    var quantity by remember { mutableStateOf(1) }
    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Column(modifier = Modifier.fillMaxSize().background(Color.Black)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.End)
                ) {
                    val firstimage = productDetail?.images?.firstOrNull()
                    val painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(firstimage ?: R.drawable.bacha)
                            .size(Size.ORIGINAL)
                            .build()
                    )
                    Image(painter = painter, contentDescription = "",
                        modifier = Modifier.height(455.dp).width(320.dp))
                    Column(
                        modifier = Modifier
                            .height(455.dp)
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .padding(30.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White)
                                .shadow(
                                    elevation = 10.dp,
                                    shape = RoundedCornerShape(10.dp),
                                )
                                .clickable { navController?.navigate("home") }
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .width(100.dp)
                                .padding(vertical = 10.dp, horizontal = 20.dp)
                                .height(250.dp)
                                .background(
                                    Color.White,
                                    shape = RoundedCornerShape(30.dp)
                                ),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .border(8.dp, Color.Gray, CircleShape)
                                    .background(Color.Transparent)
                                    .clickable(onClick = { /*TODO*/ }),
                                contentAlignment = Alignment.Center
                            ) {
                                Canvas(modifier = Modifier.size(20.dp)) {
                                    drawCircle(color = Color.White)
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .border(8.dp, Color.Gray, CircleShape)
                                    .background(Color.Transparent)
                                    .clickable(onClick = { /*TODO*/ }),
                                contentAlignment = Alignment.Center
                            ) {
                                Canvas(modifier = Modifier.size(20.dp)) {
                                    drawCircle(color = Color.Blue)
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .border(8.dp, Color.Gray, CircleShape)
                                    .background(Color.Transparent)
                                    .clickable(onClick = { /*TODO*/ }),
                                contentAlignment = Alignment.Center
                            ) {
                                Canvas(modifier = Modifier.size(20.dp)) {
                                    drawCircle(color = Color.Green)
                                }
                            }
                        }
                        Box(modifier = Modifier.height(20.dp)) {}
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
//            Text(text = "id: ${value}", fontSize = 50.sp)
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "${productDetail.name}",
                    fontSize = 24.sp,
                    color = color303030
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$ ${productDetail.price}", modifier = Modifier,
                        fontSize = 30.sp,
                        color = color303030
                    )
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "+",
                            modifier = Modifier
                                .clickable {
                                    quantity++
                                }
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 5.dp, horizontal = 12.dp),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "${quantity}",
                            modifier = Modifier.padding(horizontal = 10.dp),
                            fontSize = 18.sp,
                            color = Color.White,
                        )
                        Text(
                            text = "-",
                            modifier = Modifier
                                .clickable {
                                    if (quantity > 1) {
                                        quantity--
                                    }
                                }
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 5.dp, horizontal = 12.dp),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                }
                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star), contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "4.5",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .padding(end = 10.dp),
                        fontSize = 18.sp,
                        color = color303030,
                    )
                    Text(
                        text = "(54 review)", 
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }
                Text(
                    text = "${productDetail.description}",
                    modifier = Modifier.padding(top = 15.dp),
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Justify
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.warning_2),
                    contentDescription = "",
                    modifier = Modifier.run {
                        background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
                            .padding(10.dp)
                            .size(40.dp)
                    },
                )
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {
                        var item = Cart(product = productDetail, quantity)
                        updateCart(item)
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        text = "Add to cart", color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailReview() {
    ProductDetail()
}
