package com.manuellugodev.datacrmapp.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manuellugodev.datacrmapp.data.repository.LoginRepository

class LoginViewModelProvider(private val repository: LoginRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(LoginRepository::class.java).newInstance(repository)
    }
}