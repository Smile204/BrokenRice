package com.example.myapplication.http_model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class User @JsonCreator constructor(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("userName") val userName: String,
    @JsonProperty("role") val role: Int,
    @JsonProperty("phoneNumber") val phoneNumber: String,
    @JsonProperty("avatar") val avatar: String,
    @JsonProperty("address") val address: String,
    @JsonProperty("active") val active: Boolean,
    @JsonProperty("verify") val verify: Boolean,
    @JsonProperty("_id") val id: String,
    @JsonProperty("createdAt") val createdAt: Date,
    @JsonProperty("updatedAt") val updatedAt: Date,
    @JsonProperty("__v") val v: Int
)

data class SignUpResponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("data") val data: User
)
