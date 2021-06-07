package com.manuellugodev.datacrmapp.framework.di

import com.manuellugodev.datacrmapp.presentation.ui.contacts.MainActivity
import com.manuellugodev.datacrmapp.presentation.ui.login.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,DataModule::class,RequestModule::class])
interface AppComponent {

    fun inject(loginActivity: LoginActivity)
    fun inject(mainActivity: MainActivity)

}