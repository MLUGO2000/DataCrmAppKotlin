package com.manuellugodev.datacrmapp.framework.di

import com.manuellugodev.datacrmapp.data.repository.ContactsRepository
import com.manuellugodev.datacrmapp.data.repository.ContactsRepositoryImpl
import com.manuellugodev.datacrmapp.data.repository.LoginRepository
import com.manuellugodev.datacrmapp.data.repository.LoginRepositoryImpl
import com.manuellugodev.datacrmapp.data.sources.DataSourceContacts
import com.manuellugodev.datacrmapp.data.sources.SourceLogin
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataModule {


    @Provides
    @Singleton
    @Named("loginRepository")
    fun loginRepositoryProvider(@Named("sourceLogin")sourceLogin: SourceLogin)=
        LoginRepositoryImpl(sourceLogin)

    @Provides
    @Singleton
    @Named("contactsRepository")
    fun contactsRepositoryProvider(@Named("sourceContacts")dataSourceContacts: DataSourceContacts)=
        ContactsRepositoryImpl(dataSourceContacts)

}