package com.manuellugodev.datacrmapp.framework.sources

import android.util.Log
import com.manuellugodev.datacrmapp.data.sources.DataSourceContacts
import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import com.manuellugodev.datacrmapp.framework.extension.toDomain
import com.manuellugodev.datacrmapp.framework.retrofit.DataCrmApiService


class DataSourceContactsImpl(private val serviceApi: DataCrmApiService):DataSourceContacts {

    override suspend fun getContacts(sessionName:String): DataResult<List<Contact>> {
        val result=serviceApi.getContacts(sessionName)

        if (result.success){
           val contacts=result.contacts

            return DataResult.Success(contacts.map { it.toDomain() })
        }else{
           return DataResult.Failure(Exception(result.error.message))
        }
    }

    override suspend fun getCountContacts(sessionName: String): DataResult<Int> {
        val resultCount=serviceApi.getCountContacts(sessionName)
        return if(resultCount.success){
            val contactsNumber=resultCount.count[0].number.toInt()
            Log.i("Valor:",contactsNumber.toString())
            DataResult.Success(contactsNumber)
        }else{
            DataResult.Failure(Exception(resultCount.errorApi.message))

        }
    }
}