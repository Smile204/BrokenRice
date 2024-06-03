package com.example.appbroken_rice.httpModal

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequestModel (
    @JsonProperty("email") val email: String?,
    @JsonProperty("password") val password: String?
)