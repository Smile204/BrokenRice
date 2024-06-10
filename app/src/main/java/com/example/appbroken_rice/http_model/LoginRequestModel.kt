package com.example.myapplication.http_model

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequestModel(
    @JsonProperty("email") val email:String,
    @JsonProperty("password") val password:String
)
