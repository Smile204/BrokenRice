package com.example.appbroken_rice.classes

import com.example.myapplication.http_model.Product

data class Category(
    val _id: String,
    val name: String,
    val description: String,
    val products: List<Product>
)
