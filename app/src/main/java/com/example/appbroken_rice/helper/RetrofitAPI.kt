package com.example.appbroken_rice.helper

import android.util.Log
import com.example.chuyendoicompo.httpmodels.LoginRequestModel
import com.example.chuyendoicompo.httpmodels.LoginResponseModel
import com.example.chuyendoicompo.httpmodels.ProductResponseModel
import com.example.chuyendoicompo.httpmodels.RegisterRequestModel
import com.example.chuyendoicompo.httpmodels.RegisterResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitAPI {
    private val retrofit = RetrofitClient.getClient()
    private val api = retrofit.create(IRetrofit::class.java)

    fun register(
        user: RegisterRequestModel,
        callback: (RegisterResponseModel?) -> Unit
    ) {
        api.register(user).enqueue(object : Callback<RegisterResponseModel> {
            override fun onResponse(
                call: Call<RegisterResponseModel>,
                response: Response<RegisterResponseModel>
            ) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    callback(registerResponse)
                } else {
                    Log.d("Failed to register", response.message())
                }
            }

            override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                Log.d("Failed to register", t.message ?: "Unknown error")
            }
        })
    }

    fun login(
        body: LoginRequestModel,
        callback: (LoginResponseModel?) -> Unit
    ) {
        api.login(body).enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    callback(result)
                } else {
                    Log.d("Failed to login", response.message())
                }
            }

            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                Log.d("Failed to login", t.message ?: "Unknown error")
            }
        })
    }

    fun getProduct(
        callback: (ProductResponseModel?) -> Unit
    ) {
        api.getProduct().enqueue(object : Callback<ProductResponseModel> {
            override fun onResponse(
                call: Call<ProductResponseModel>,
                response: Response<ProductResponseModel>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    callback(result)
                } else {
                    Log.d("Get product to Failed", response.message())
                }
            }

            override fun onFailure(call: Call<ProductResponseModel>, t: Throwable) {
                Log.d("Get product to Failed", t.message ?: "Unknown error")
            }
        })
    }

    fun getProductByID(
        id: String,
        callback: (ProductResponseModel?) -> Unit
    ) {
        api.getProductById(id).enqueue(object : Callback<ProductResponseModel> {
            override fun onResponse(
                call: Call<ProductResponseModel>,
                response: Response<ProductResponseModel>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    callback(result)
                } else {
                    Log.d("Get product to Failed", response.message())
                }
            }

            override fun onFailure(call: Call<ProductResponseModel>, t: Throwable) {
                Log.d("Get product to Failed", t.message ?: "Unknown error")
            }
        })
    }
}