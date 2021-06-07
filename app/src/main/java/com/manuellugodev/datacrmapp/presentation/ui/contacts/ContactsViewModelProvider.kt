package com.manuellugodev.datacrmapp.presentation.ui.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manuellugodev.datacrmapp.data.repository.ContactsRepository

class ContactsViewModelProvider(private val repository: ContactsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ContactsRepository::class.java).newInstance(repository)
    }
}