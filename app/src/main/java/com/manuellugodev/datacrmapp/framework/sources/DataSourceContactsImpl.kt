package com.manuellugodev.datacrmapp.framework.sources

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
}