package com.manuellugodev.datacrmapp.framework.retrofit

import com.manuellugodev.datacrmapp.framework.retrofit.model.LoginRequest
import com.manuellugodev.datacrmapp.framework.retrofit.model.response.ChallegeResponse
import com.manuellugodev.datacrmapp.framework.retrofit.model.response.ContactsCountResponse
import com.manuellugodev.datacrmapp.framework.retrofit.model.response.ContactsResponse
import com.manuellugodev.datacrmapp.framework.retrofit.model.response.LoginResponse
import retrofit2.http.*

interface DataCrmApiService {


    @GET("webservice.php?operation=${Constans.OP_GETCHALLENGE}")
    suspend fun getChallenge(@Query("username") userName:String):ChallegeResponse

    @POST("webservice.php?")
    @FormUrlEncoded
    suspend fun postLogin(
            @Field("operation") operation:String,
            @Field("username") userName: String,
            @Field("accessKey") accessKey:String):LoginResponse

    @GET("webservice.php?operation=${Constans.OP_QUERY}&query=select * from Contacts;")
    suspend fun getContacts(@Query ("sessionName") session:String):ContactsResponse

    @GET("webservice.php?operation=${Constans.OP_QUERY}&query=select COUNT(*) from Contacts;")
    suspend fun getCountContacts(@Query("sessionName") session: String):ContactsCountResponse




}