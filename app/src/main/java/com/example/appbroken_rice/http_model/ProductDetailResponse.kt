package com.example.myapplication.http_model

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDetail(
    @JsonProperty("_id") val _id: String?,
    @JsonProperty("name") val name: String?,
    @JsonProperty("price") val price: Int?,
    @JsonProperty("quantity") val quantity: Int?,
    @JsonProperty("images") val images: List<String>?,
    @JsonProperty("description") val description: String?,
    @JsonProperty("size") val size: String?,
    @JsonProperty("origin") val origin: String?,
    @JsonProperty("type") val type: String?,
    @JsonProperty("category") val category: String?
)

data class ProductDetailResponse(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("data") val data: ProductDetail
)
