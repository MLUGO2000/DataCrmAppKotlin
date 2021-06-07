package com.manuellugodev.datacrmapp.framework.retrofit.model.response

import com.google.gson.annotations.SerializedName

data class ErrorApi(
    @SerializedName("code") val codeError:String,
    @SerializedName("message") val message:String
)
