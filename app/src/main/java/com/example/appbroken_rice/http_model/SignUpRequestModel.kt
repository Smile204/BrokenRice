package com.example.myapplication.http_model

import com.fasterxml.jackson.annotation.JsonProperty

//Model gui di khi dang ky
data class SignUpRequestModel(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("phoneNumber") val phoneNumber: String ?= "0797593569"
)
