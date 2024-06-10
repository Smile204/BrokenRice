package com.example.myapplication.http_model

import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("userName") val userName: String,
    @JsonProperty("role") val role: Int,
    @JsonProperty("phoneNumber") val phoneNumber: String,
    @JsonProperty("avatar") val avatar: String,
    @JsonProperty("address") val address: String,
    @JsonProperty("active") val active: Boolean,
    @JsonProperty("verify") val verify: Boolean,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String
)

data class LoginResponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: UserResponse
)
