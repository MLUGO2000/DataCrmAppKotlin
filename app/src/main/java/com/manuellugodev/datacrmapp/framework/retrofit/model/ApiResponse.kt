package com.manuellugodev.datacrmapp.framework.retrofit.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("success")val success:Boolean
)
