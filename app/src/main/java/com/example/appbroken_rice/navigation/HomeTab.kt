package com.example.appbroken_rice.navigation

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appbroken_rice.R
import com.example.appbroken_rice.classes.Category
import com.example.appbroken_rice.common.HeaderCommon
import com.example.appbroken_rice.items.ItemCateHome
import com.example.appbroken_rice.items.ItemProductHome
import com.example.appbroken_rice.ui.theme.AppBroken_riceTheme
import com.example.myapplication.helper.RetrofitAPI
import com.example.myapplication.http_model.Product
import com.example.myapplication.http_model.ProductResponseModel

@Composable
fun MainHome(onProductClick: (String) -> Unit = {}) {
    val context = LocalContext.current
    var listProduct by remember {
        mutableStateOf(listOf<Category>())
    }

    fun getProductCallBack(response: ProductResponseModel?) {
        val productList = response?.data
        listProduct = productList?.map { apiCategory ->
            Category(
                apiCategory._id,
                apiCategory.name,
                apiCategory.description,
                products = apiCategory.products.map { apiProduct ->
                    Product(
                        apiProduct._id,
                        apiProduct.name,
                        apiProduct.price,
                        apiProduct.quantity,
                        apiProduct.images,
                        apiProduct.description,
                        apiProduct.size,
                        apiProduct.origin,
                        apiProduct.typeId,
                        apiProduct.categoryId,
                        apiProduct.createAt,
                        apiProduct.updateAt,
                        apiProduct.__v,
                        apiProduct.hiddenProduct
                    )
                }
            )
        } ?: emptyList()
        Log.d("List product", "getProductCallBack: $listProduct")
    }

    fun getAllProduct() {
        val reTrofitAPI = RetrofitAPI()
        try {
            reTrofitAPI.getAllProduct(callback = { getProductCallBack(it) })
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    getAllProduct()

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

        val data = listProduct
        Box(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth()
        ) {
            ProductList(data, onProductClick = onProductClick)
        }
    }
}

@Composable
fun ProductList(cate: List<Category>, onProductClick: (String) -> Unit = {}) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(cate) { category ->
            ItemCateHome(name = category.name)
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(category.products) { product ->
                    ItemProductHome(product = product, onClick = {
                        product._id?.let {
                            onProductClick(it)
                        }
                    })
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