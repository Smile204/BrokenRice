package com.example.appbroken_rice.classes

import com.example.myapplication.http_model.ProductDetail

data class Cart(
    val product: ProductDetail?,
    val quantity: Int
)
