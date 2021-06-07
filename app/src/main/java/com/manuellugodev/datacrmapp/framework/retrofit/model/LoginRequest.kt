package com.manuellugodev.datacrmapp.framework.retrofit.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("operation")val operation:String,
    @SerializedName("username") val userName:String,
    @SerializedName("accesKey") val accessKey:String
    )
