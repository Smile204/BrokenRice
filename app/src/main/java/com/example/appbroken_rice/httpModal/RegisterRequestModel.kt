package com.example.appbroken_rice.httpModal

import com.fasterxml.jackson.annotation.JsonProperty

//Model gui len server
data class RegisterRequestModel(
    @JsonProperty("name") val name:String,
    @JsonProperty("email") val email:String,
    @JsonProperty("pass") val pass:String
)
