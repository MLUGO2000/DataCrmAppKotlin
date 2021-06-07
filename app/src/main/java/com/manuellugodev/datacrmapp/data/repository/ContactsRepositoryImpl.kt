package com.manuellugodev.datacrmapp.data.repository

import com.manuellugodev.datacrmapp.data.sources.DataSourceContacts
import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.vo.DataResult

class ContactsRepositoryImpl(private val source:DataSourceContacts): ContactsRepository {

    override suspend fun getContancts(sessionName: String): DataResult<List<Contact>> =
        source.getContacts(sessionName)
}