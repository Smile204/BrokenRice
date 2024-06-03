package com.example.appbroken_rice.classes

import com.fasterxml.jackson.annotation.JsonProperty

data class UserModel(
    @JsonProperty("_id") val _id : String?,
    @JsonProperty("name") val name : String?,
    @JsonProperty("email") val email : String?,
    @JsonProperty("pass") val pass : String?,
    @JsonProperty("__v") val __v : String?,
)
