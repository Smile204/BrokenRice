package com.example.appbroken_rice.helper

import com.example.appbroken_rice.httpModal.LoginRequestModel
import com.example.appbroken_rice.httpModal.LoginResponseModel
import com.example.appbroken_rice.httpModal.RegisterRequestModel
import com.example.appbroken_rice.httpModal.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IRetrofit {
    //Khai bao cac API

    //Dang ky tai khoan
    @POST("phanf tiep theo cua API")
    fun register(@Body body:RegisterRequestModel):Call<RegisterResponseModel>

    //Dang nhap
    @POST("")
    fun login(@Body body:LoginRequestModel): Call<LoginResponseModel>


}