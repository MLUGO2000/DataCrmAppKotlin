package com.manuellugodev.datacrmapp.framework.di

import com.manuellugodev.datacrmapp.data.sources.DataSourceContacts
import com.manuellugodev.datacrmapp.data.sources.SourceLogin
import com.manuellugodev.datacrmapp.framework.retrofit.DataCrmApiService
import com.manuellugodev.datacrmapp.framework.sources.DataSourceContactsImpl
import com.manuellugodev.datacrmapp.framework.sources.LoginApiDataCrm
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule {


    @Provides
    @Named("sourceLogin")
    fun sourceLoginProvider(@Named("ApiService") service:DataCrmApiService):SourceLogin =
        LoginApiDataCrm(service)

    @Provides
    @Named("sourceContacts")
    fun sourceContactsProvider(@Named("ApiService") service:DataCrmApiService):DataSourceContacts =
        DataSourceContactsImpl(service)
}