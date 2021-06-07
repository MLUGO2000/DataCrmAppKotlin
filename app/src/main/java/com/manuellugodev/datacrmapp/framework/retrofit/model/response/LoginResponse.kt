package com.manuellugodev.datacrmapp.framework.retrofit.model.response

import com.google.gson.annotations.SerializedName
import com.manuellugodev.datacrmapp.framework.retrofit.model.UserLoginApi

data class LoginResponse(
    @SerializedName("success")val success:Boolean,
    @SerializedName("result") val resultLogin:UserLoginApi,
    @SerializedName("error")  val error:ErrorApi
)
