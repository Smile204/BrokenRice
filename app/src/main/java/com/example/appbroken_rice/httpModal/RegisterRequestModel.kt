package com.example.chuyendoicompo.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterRequestModel(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("name") val name: String,
)
