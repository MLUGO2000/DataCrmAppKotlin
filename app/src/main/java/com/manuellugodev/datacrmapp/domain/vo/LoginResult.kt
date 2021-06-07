package com.manuellugodev.datacrmapp.domain.vo


sealed class LoginResult<out T>{
    class Loading<out T> : LoginResult<T>()
    data class Success<out T>(val user:T):LoginResult<T>()
    data class Failure<out T>(val e:Exception):LoginResult<T>()
}
