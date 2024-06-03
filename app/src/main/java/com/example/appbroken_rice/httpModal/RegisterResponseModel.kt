package com.example.appbroken_rice.httpModal

import com.fasterxml.jackson.annotation.JsonProperty

//Model nhan duoc sau khi dang ky
data class RegisterResponseModel(
    @JsonProperty("status") val status:Boolean
)
