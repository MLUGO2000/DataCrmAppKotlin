package com.manuellugodev.datacrmapp.data.repository

import com.manuellugodev.datacrmapp.domain.login.LoginUser
import com.manuellugodev.datacrmapp.domain.login.Token
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import com.manuellugodev.datacrmapp.domain.vo.LoginResult

interface LoginRepository {

    suspend fun getToken(userName: String):DataResult<Token>

    suspend fun loginUser(userName:String,password:String,token:String):LoginResult<LoginUser>
}