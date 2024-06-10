package com.example.myapplication.http_model

import com.fasterxml.jackson.annotation.JsonProperty
data class Product(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("price") val price: Int,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("images") val images: List<String>,
    @JsonProperty("description") val description: String,
    @JsonProperty("size") val size: String,
    @JsonProperty("origin") val origin: String,
    @JsonProperty("typeId") val typeId: String,
    @JsonProperty("categoryId") val categoryId: String,
    @JsonProperty("createAt") val createAt: String,
    @JsonProperty("updateAt") val updateAt: String,
    @JsonProperty("__v") val __v: Int,
    @JsonProperty("hiddenProduct") val hiddenProduct: Boolean
)
data class Category(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("products") val products: List<Product>
)

data class ProductResponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("data") val data: List<Category>,
    @JsonProperty("message") val message: String
)
