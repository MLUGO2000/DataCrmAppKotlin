package com.manuellugodev.datacrmapp.framework.retrofit.model

import com.google.gson.annotations.SerializedName

data class UserLoginApi(
    @SerializedName("sessionName") val sessionName:String,
    @SerializedName("userId") val userId:String,
    @SerializedName("version") val version:String,
    @SerializedName("vtigerVersion") val vTigerVersion:String
)
