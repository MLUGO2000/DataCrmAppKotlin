package com.manuellugodev.datacrmapp.framework.retrofit.model.response

import com.google.gson.annotations.SerializedName
import com.manuellugodev.datacrmapp.framework.retrofit.model.ContactApi

data class ContactsResponse(
    @SerializedName("success")val success:Boolean,
    @SerializedName("result")val contacts:List<ContactApi>,
    @SerializedName("error")  val error:ErrorApi
)
