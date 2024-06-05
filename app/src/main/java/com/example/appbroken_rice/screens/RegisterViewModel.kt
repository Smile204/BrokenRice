package com.example.appbroken_rice.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appbroken_rice.helper.RetrofitAPI
import com.example.chuyendoicompo.httpmodels.RegisterRequestModel
import com.example.chuyendoicompo.httpmodels.RegisterResponseModel
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val retrofitAPI = RetrofitAPI()

    var registerResult: ((RegisterResponseModel?) -> Unit)? = null
    var registerError: ((String) -> Unit)? = null

    fun register(email: String, password: String, name: String) {
        val registerRequest = RegisterRequestModel(email, password, name)
        viewModelScope.launch {
            retrofitAPI.register(registerRequest) { response ->
                if (response != null) {
                    registerResult?.invoke(response)
                } else {
                    registerError?.invoke("Registration failed")
                }
            }
        }
    }
}
