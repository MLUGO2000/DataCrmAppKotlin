package com.manuellugodev.datacrmapp.framework.retrofit.model

import com.google.gson.annotations.SerializedName

data class NumberContacts(
    @SerializedName("count") val number:String
)