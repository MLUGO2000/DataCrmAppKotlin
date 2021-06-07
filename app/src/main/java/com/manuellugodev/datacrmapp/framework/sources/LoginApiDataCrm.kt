package com.manuellugodev.datacrmapp.framework.sources

import com.manuellugodev.datacrmapp.data.sources.SourceLogin
import com.manuellugodev.datacrmapp.domain.login.LoginUser
import com.manuellugodev.datacrmapp.domain.login.Token
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import com.manuellugodev.datacrmapp.domain.vo.LoginResult
import com.manuellugodev.datacrmapp.framework.extension.toDomain
import com.manuellugodev.datacrmapp.framework.extension.toMD5Hash
import com.manuellugodev.datacrmapp.framework.retrofit.Constans
import com.manuellugodev.datacrmapp.framework.retrofit.DataCrmApiService
import com.manuellugodev.datacrmapp.framework.retrofit.model.LoginRequest

class LoginApiDataCrm(private val serviceApi:DataCrmApiService):SourceLogin {

    override suspend fun getTokenApi(userName: String):DataResult<Token> {
        val result=serviceApi.getChallenge(userName)

        if(result.success){
            val token=result.resultToken.toDomain()
            return DataResult.Success(token)
        }else{
            return DataResult.Failure(Exception(result.error.message))
        }
    }

    override suspend fun sendLoginRequest(
        userName: String,
        password: String,
        token:String
    ): LoginResult<LoginUser> {

        val access="$token$password"
        val accessKey=access.toMD5Hash()
        val result=serviceApi.postLogin("login",userName, accessKey)

        if (result.success){
            return LoginResult.Success(result.resultLogin.toDomain())
        }else{
            return LoginResult.Failure(Exception(result.error.message))
        }
    }
}