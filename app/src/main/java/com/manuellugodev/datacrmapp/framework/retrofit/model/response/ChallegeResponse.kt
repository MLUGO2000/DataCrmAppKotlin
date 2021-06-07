package com.manuellugodev.datacrmapp.framework.retrofit.model.response

import com.google.gson.annotations.SerializedName
import com.manuellugodev.datacrmapp.framework.retrofit.model.TokenApi

data class ChallegeResponse(
    @SerializedName("success")val success:Boolean,
    @SerializedName("result") val resultToken:TokenApi,
    @SerializedName("error")  val error:ErrorApi
)
