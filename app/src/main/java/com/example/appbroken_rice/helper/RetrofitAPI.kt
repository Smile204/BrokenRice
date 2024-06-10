package com.example.myapplication.helper

import android.util.Log
import com.example.appbroken_rice.helper.RetrofitClient
import com.example.myapplication.http_model.LoginRequestModel
import com.example.myapplication.http_model.LoginResponseModel
import com.example.myapplication.http_model.ProductDetailResponse
import com.example.myapplication.http_model.ProductResponseModel
import com.example.myapplication.http_model.SignUpRequestModel
import com.example.myapplication.http_model.SignUpResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitAPI {
    private val retrofit = RetrofitClient.getClient()
    private val iRetrofit = retrofit.create(IRetrofit::class.java)

    //Lay chi tiet san pham
    fun getProductDetail(id: String?,
                         callback: (ProductDetailResponse?) -> Unit
    ) {
        iRetrofit.getProductDetail(id).enqueue(
            object : Callback<ProductDetailResponse> {
                override fun onResponse(
                    call: Call<ProductDetailResponse>,
                    response: Response<ProductDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        val productDetailResponse = response.body()
                        callback(productDetailResponse)
                    } else {
                        Log.d(">>>Failed to GET PRODUCT DETAIL", response.message())
                    }
                }

                override fun onFailure(call: Call<ProductDetailResponse>, t: Throwable) {
                    Log.d(">>>Failed to GET PRODUCT DETAIL", t.message ?: "Unknown error")
                }
            })
    }

    //Lay danh sach san pham
    fun getAllProduct(
        callback: (ProductResponseModel?) -> Unit
    ) {
        iRetrofit.getAllProducts().enqueue(
            object : Callback<ProductResponseModel> {
                override fun onResponse(
                    call: Call<ProductResponseModel>,
                    response: Response<ProductResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val productResponse = response.body()
                        callback(productResponse)
                    } else {
                        Log.d(">>>Failed to GET PRODUCT", response.message())
                    }
                }

                override fun onFailure(call: Call<ProductResponseModel>, t: Throwable) {
                    Log.d(">>>Failed to GET PRODUCT", t.message ?: "Unknown error")
                }
            })
    }

    //Dang nhap
    fun login(
        body: LoginRequestModel,
        callback: (LoginResponseModel?) -> Unit
    ) {
        iRetrofit.signIn(body).enqueue(
            object : Callback<LoginResponseModel> {
                override fun onResponse(
                    call: Call<LoginResponseModel>,
                    response: Response<LoginResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        callback(loginResponse)
                    } else {
                        Log.d(">>>LOGIN SUCCESS", response.message())
                    }
                }

                override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                    Log.d(">>>LOGIN FAILED", t.message ?: "Unknown error")
                }
            })
    }

    //Dang ky
    fun register(
        body: SignUpRequestModel,
        callback: (SignUpResponseModel?) -> Unit
    ) {
        iRetrofit.signUp(body).enqueue(
            object : Callback<SignUpResponseModel> {
                override fun onResponse(
                    call: Call<SignUpResponseModel>,
                    response: Response<SignUpResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val registerResponseModel = response.body()
                        callback(registerResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<SignUpResponseModel>, t: Throwable) {
                    Log.d(">>>Failed to register", t.message ?: "Unknown error")
                }
            })
    }

}