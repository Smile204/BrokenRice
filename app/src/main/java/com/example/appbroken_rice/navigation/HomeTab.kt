package com.example.appbroken_rice.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appbroken_rice.R
import com.example.appbroken_rice.classes.Category
import com.example.appbroken_rice.classes.lstData
import com.example.appbroken_rice.common.HeaderCommon
import com.example.appbroken_rice.items.ItemCateHome
import com.example.appbroken_rice.items.ItemProductHome
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme

@Composable
fun MainHome() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        HeaderCommon(
            iconLeft = R.drawable.menu,
            title = "Deliver to ",
            title1 = "Choose your city and state",
            iconRight = R.drawable.logooo,
            icondow = true
        )

        val data = lstData
        Box(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth()
        ) {
            ProductList(data)
        }
    }
}

@Composable
fun ProductList(cate: List<Category>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(cate) { category ->
            ItemCateHome(name = category.nameCategory)
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(category.products) { product ->
                    ItemProductHome(product = product)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainHome() {
    AppBroken_riceTheme {
        MainHome()
    }
}