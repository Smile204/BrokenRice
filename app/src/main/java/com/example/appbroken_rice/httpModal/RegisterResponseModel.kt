package com.example.chuyendoicompo.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class UserModelRegister(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("role") val role: Int,
    @JsonProperty("carts") val carts: List<Any>,
    @JsonProperty("isVerified") val isVerified: Int,
    @JsonProperty("available") val available: Boolean,
    @JsonProperty("_id") val _id: String,
    @JsonProperty("createdAt") val createdAt: Date,
    @JsonProperty("updatedAt") val updatedAt: Date,
    @JsonProperty("__v") val version: Int
)

data class RegisterResponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("user") val user: UserModelRegister
)