package com.manuellugodev.datacrmapp.domain.login

data class Token(
    val token:String,
    val serverTime:Long,
    val expireTime:Long
)
