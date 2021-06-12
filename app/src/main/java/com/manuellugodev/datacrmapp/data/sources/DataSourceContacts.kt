package com.manuellugodev.datacrmapp.data.sources

import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import com.manuellugodev.datacrmapp.framework.retrofit.model.response.ContactsCountResponse

interface DataSourceContacts {

    suspend fun getContacts(sessionName:String):DataResult<List<Contact>>

    suspend fun getCountContacts(sessionName: String):DataResult<Int>
}