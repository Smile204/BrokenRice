package com.example.chuyendoicompo.httpmodels

import com.example.appbroken_rice.classes.Product
import com.fasterxml.jackson.annotation.JsonProperty

data class ProductResponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("data") val data: List<Product>
)
