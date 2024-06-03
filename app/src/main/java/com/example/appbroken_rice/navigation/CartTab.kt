package com.example.appbroken_rice.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbroken_rice.R
import com.example.appbroken_rice.classes.lstcart
import com.example.appbroken_rice.common.roboto_bold
import com.example.appbroken_rice.common.roboto_regular
import com.example.appbroken_rice.items.ItemCart
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.appbroken_rice.ui.theme.colorFF7400

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Your Favorite", color = colorFF7400,
                fontFamily = FontFamily(roboto_bold),
                fontSize = 22.sp
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.checkdefault),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Check all",
                    color = Color.White,
                    modifier = Modifier.padding(start = 10.dp),
                    fontFamily = FontFamily(roboto_bold),
                    fontSize = 12.sp
                )
            }
        }

        val cartdata = lstcart
        LazyColumn(
            modifier = Modifier
                .height(450.dp)
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(cartdata) { product ->
                ItemCart(product = product)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .padding(bottom = 100.dp)
                .weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Items: 3", color = Color.White,
                    fontFamily = FontFamily(roboto_regular),
                    fontSize = 10.sp
                )
                Text(
                    text = "36 $", color = Color.White, fontFamily = FontFamily(roboto_regular),
                    fontSize = 10.sp
                )
            }
            Row(modifier = Modifier.padding(vertical = 6.dp)) {
                Text(
                    text = "Address: ",
                    color = Color.White,
                    fontFamily = FontFamily(roboto_regular),
                    fontSize = 10.sp
                )
                Text(
                    text = "121/45 streets 5 ward 3 block LinhXuan state ThuDuc City Hochiminh",
                    maxLines = 1,
                    color = Color.White,
                    fontFamily = FontFamily(roboto_bold),
                    fontSize = 10.sp
                )
            }
            Row(modifier = Modifier.padding(vertical = 6.dp)) {
                Text(
                    text = "Payment Method: ", color = Color.White, fontFamily = FontFamily(roboto_regular),
                    fontSize = 10.sp
                )
                Text(
                    text = "MB Bank", color = Color.White, fontFamily = FontFamily(roboto_bold),
                    fontSize = 10.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorFF7400
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Check out", color = Color.White,
                    modifier = Modifier.padding(vertical = 6.dp),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemCart() {
    AppBroken_riceTheme {
        CartScreen()
    }
}