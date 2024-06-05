package com.example.appbroken_rice.helper

import com.example.chuyendoicompo.httpmodels.LoginRequestModel
import com.example.chuyendoicompo.httpmodels.LoginResponseModel
import com.example.chuyendoicompo.httpmodels.ProductResponseModel
import com.example.chuyendoicompo.httpmodels.RegisterRequestModel
import com.example.chuyendoicompo.httpmodels.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IRetrofit {
    @POST("/users/register")
    fun register(@Body body: RegisterRequestModel): Call<RegisterResponseModel>

    @POST("/users/login")
    fun login(@Body body: LoginRequestModel): Call<LoginResponseModel>

    @GET("/products")
    fun getProduct(): Call<ProductResponseModel>

    //http://localhost:8888/products/?id=66052d25b8c67759afed66d8
    @GET("/products/")
    fun getProductById(@Query("id") id: String): Call<ProductResponseModel>

}