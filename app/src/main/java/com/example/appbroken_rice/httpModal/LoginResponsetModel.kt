package com.example.chuyendoicompo.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class Cart(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("date") val date: Date,
    @JsonProperty("total") val total: Int,
    @JsonProperty("status") val status: Int
)

data class UserModelLogin(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("role") val role: Int,
    @JsonProperty("carts") val carts: List<Cart>,
    @JsonProperty("isVerified") val isVerified: Int,
    @JsonProperty("available") val available: Boolean,
    @JsonProperty("createdAt") val createdAt: Date,
    @JsonProperty("updatedAt") val updatedAt: Date,
    @JsonProperty("__v") val version: Int
)

data class LoginResponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("user") val user: UserModelLogin
)