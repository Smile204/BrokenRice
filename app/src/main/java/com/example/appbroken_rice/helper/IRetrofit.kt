package com.example.myapplication.helper

import com.example.myapplication.http_model.LoginRequestModel
import com.example.myapplication.http_model.LoginResponseModel
import com.example.myapplication.http_model.ProductDetailResponse
import com.example.myapplication.http_model.ProductResponseModel
import com.example.myapplication.http_model.SignUpRequestModel
import com.example.myapplication.http_model.SignUpResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IRetrofit {
    //Khai bao cac API

    //Dang ky tai khoan
    @POST("users/signup")
    fun signUp(@Body body : SignUpRequestModel): Call<SignUpResponseModel>

    //Dang nhap
    @POST("users/signin")
    fun signIn(@Body body : LoginRequestModel): Call<LoginResponseModel>

    //Lay danh sach san pham
    //http://localhost:8888/categories/get_all_cate
    @GET("categories/get_all_cate")
    fun getAllProducts(): Call<ProductResponseModel>

    //Lay chi tiet san pham
    //http://localhost:8888/products/get_product_detailt/66003d1f31f08d88995f8ab3
    @GET("products/get_product_detailt/{id}")
    fun getProductDetail(@Path("id") id : String?): Call<ProductDetailResponse>

}