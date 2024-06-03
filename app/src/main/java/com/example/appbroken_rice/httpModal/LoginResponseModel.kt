package com.example.appbroken_rice.httpModal

import com.example.appbroken_rice.classes.UserModel
import com.fasterxml.jackson.annotation.JsonProperty

data class LoginResponseModel(
    @JsonProperty("status") val status: Boolean?,
    @JsonProperty("user") val user:UserModel?
)
