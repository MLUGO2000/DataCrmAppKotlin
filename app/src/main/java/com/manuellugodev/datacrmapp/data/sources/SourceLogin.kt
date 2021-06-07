package com.manuellugodev.datacrmapp.data.sources

import com.manuellugodev.datacrmapp.domain.login.LoginUser
import com.manuellugodev.datacrmapp.domain.login.Token
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import com.manuellugodev.datacrmapp.domain.vo.LoginResult

interface SourceLogin{

    suspend fun getTokenApi(userName: String):DataResult<Token>
    suspend fun sendLoginRequest(userName:String,password:String,token: String):LoginResult<LoginUser>
}