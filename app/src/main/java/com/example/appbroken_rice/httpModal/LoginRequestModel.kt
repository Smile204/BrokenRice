package com.example.chuyendoicompo.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequestModel(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
)
