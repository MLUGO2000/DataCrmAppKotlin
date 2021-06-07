package com.manuellugodev.datacrmapp.domain.login

data class LoginUser(
    val sessionName:String,
    val userId:String,
    val version:String,
    val vTigerVersion:String
)
