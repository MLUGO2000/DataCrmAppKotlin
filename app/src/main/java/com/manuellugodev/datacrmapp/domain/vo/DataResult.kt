package com.manuellugodev.datacrmapp.domain.vo

sealed class DataResult<out T> {
    class Loading<out T> : DataResult<T>()
    data class Success<out T>(val data:T):DataResult<T>()
    data class Failure<out T>(val e:Exception):DataResult<T>()
}