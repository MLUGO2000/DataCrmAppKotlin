package com.manuellugodev.datacrmapp.framework.extension

import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.login.LoginUser
import com.manuellugodev.datacrmapp.domain.login.Token
import com.manuellugodev.datacrmapp.framework.retrofit.model.ContactApi
import com.manuellugodev.datacrmapp.framework.retrofit.model.TokenApi
import com.manuellugodev.datacrmapp.framework.retrofit.model.UserLoginApi
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest

fun TokenApi.toDomain():Token = Token(token, serverTime, expireTime)

fun ContactApi.toDomain():Contact = Contact(id, contactNo, lastName, createdTime)

fun UserLoginApi.toDomain():LoginUser = LoginUser(sessionName, userId, version, vTigerVersion)

fun String.toMD5Hash():String{
    return try {
        val md5=MessageDigest.getInstance("MD5")
        val md5Hash= BigInteger(1, md5.digest(this.toByteArray())).toString(16).padStart(32, '0')

        md5Hash
    }catch (e:Exception){

        "Error Hash"
    }
}



