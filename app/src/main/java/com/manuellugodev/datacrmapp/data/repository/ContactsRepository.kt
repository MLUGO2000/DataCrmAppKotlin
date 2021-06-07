package com.manuellugodev.datacrmapp.data.repository

import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.vo.DataResult

interface ContactsRepository {

    suspend fun getContancts(sessionName:String):DataResult<List<Contact>>
}