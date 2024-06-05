package com.example.appbroken_rice.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appbroken_rice.helper.RetrofitAPI
import com.example.chuyendoicompo.httpmodels.LoginRequestModel
import com.example.chuyendoicompo.httpmodels.LoginResponseModel
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val retrofitAPI = RetrofitAPI()

    var loginResult: ((LoginResponseModel?) -> Unit)? = null
    var loginError: ((String) -> Unit)? = null

    fun login(email: String, password: String) {
        val loginRequest = LoginRequestModel(email, password)
        viewModelScope.launch {
            retrofitAPI.login(loginRequest) { response ->
                if (response != null) {
                    loginResult?.invoke(response)
                } else {
                    loginError?.invoke("Login failed")
                }
            }
        }
    }
}
