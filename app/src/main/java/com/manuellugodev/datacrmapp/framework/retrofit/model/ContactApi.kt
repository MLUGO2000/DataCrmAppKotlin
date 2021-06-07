package com.manuellugodev.datacrmapp.framework.retrofit.model

import com.google.gson.annotations.SerializedName

data class ContactApi(
    @SerializedName("id")val id:String,
    @SerializedName("contact_no")val contactNo:String,
    @SerializedName("lastname")val lastName:String,
    @SerializedName("createdtime")val createdTime:String
)
