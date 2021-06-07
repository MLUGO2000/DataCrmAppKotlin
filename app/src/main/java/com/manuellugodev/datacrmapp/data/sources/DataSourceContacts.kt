package com.manuellugodev.datacrmapp.data.sources

import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.vo.DataResult

interface DataSourceContacts {

    suspend fun getContacts(sessionName:String):DataResult<List<Contact>>
}