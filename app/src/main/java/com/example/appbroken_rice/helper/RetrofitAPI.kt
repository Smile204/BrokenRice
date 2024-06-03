package com.example.appbroken_rice.helper

import android.util.Log
import com.example.appbroken_rice.httpModal.LoginRequestModel
import com.example.appbroken_rice.httpModal.LoginResponseModel
import com.example.appbroken_rice.httpModal.RegisterRequestModel
import com.example.appbroken_rice.httpModal.RegisterResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitAPI {
    private val retrofit = RetrofitClient.getClient()
    private val iRetrofit = retrofit.create(IRetrofit::class.java)

    fun register(
        body: RegisterRequestModel,
        callback: (RegisterResponseModel?) -> Unit
    ) {
        iRetrofit.register(body).enqueue(
            object : Callback<RegisterResponseModel> {
                override fun onResponse(
                    call: Call<RegisterResponseModel>,
                    response: Response<RegisterResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val registerResponseModel = response.body()
                        callback(registerResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }

    fun Login(
        body: LoginRequestModel,
        callback: (LoginResponseModel?) -> Unit
    ) {
        iRetrofit.login(body).enqueue(
            object : Callback<LoginResponseModel> {
                override fun onResponse(
                    call: Call<LoginResponseModel>,
                    response: Response<LoginResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val loginResponseModel = response.body()
                        callback(loginResponseModel)
                    } else {
                        Log.d(">>>Failed to login", response.message())
                    }
                }

                override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }


}