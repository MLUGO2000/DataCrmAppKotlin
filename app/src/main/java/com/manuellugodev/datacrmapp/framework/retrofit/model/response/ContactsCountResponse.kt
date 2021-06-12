package com.manuellugodev.datacrmapp.framework.retrofit.model.response

import com.google.gson.annotations.SerializedName
import com.manuellugodev.datacrmapp.framework.retrofit.model.NumberContacts

data class ContactsCountResponse(
        @SerializedName("success")val success:Boolean,
        @SerializedName("result")val count:List<NumberContacts>,
        @SerializedName("error")val errorApi: ErrorApi
)
