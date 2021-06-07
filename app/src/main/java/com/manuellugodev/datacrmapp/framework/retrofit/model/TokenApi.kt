package com.manuellugodev.datacrmapp.framework.retrofit.model

import com.google.gson.annotations.SerializedName

data class TokenApi(
    @SerializedName("token") val token:String,
    @SerializedName("serverTime")val serverTime:Long,
    @SerializedName("expireTime")val expireTime:Long

)