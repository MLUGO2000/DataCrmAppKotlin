package com.manuellugodev.datacrmapp.data.repository

import com.manuellugodev.datacrmapp.data.sources.SourceLogin
import com.manuellugodev.datacrmapp.domain.login.LoginUser
import com.manuellugodev.datacrmapp.domain.vo.LoginResult

class LoginRepositoryImpl(private val source:SourceLogin): LoginRepository {

    override suspend fun getToken(userName:String) =
        source.getTokenApi(userName)

    override suspend fun loginUser(userName: String, password: String,token:String): LoginResult<LoginUser> =
       source.sendLoginRequest(userName,password,token)

}