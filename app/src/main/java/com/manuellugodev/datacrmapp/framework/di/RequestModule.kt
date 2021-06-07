package com.manuellugodev.datacrmapp.framework.di

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.manuellugodev.datacrmapp.framework.retrofit.Constans
import com.manuellugodev.datacrmapp.framework.retrofit.DataCrmApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
class RequestModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider()=Constans.BASE_URL

    @Provides
    @Singleton
    @Named("httpClient")
    fun httpClientProvider(): OkHttpClient {
         val okHttpClient: OkHttpClient = HttpLoggingInterceptor().run {
            level=HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder().addInterceptor(this).build()
        }

        return okHttpClient
    }

    @Provides
    @Singleton
    @Named("buildRetrofit")
    fun buildRetrofitProvider(@Named("baseUrl")baseUrl:String,@Named("httpClient")client:OkHttpClient) =
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    @Provides
    @Named("ApiService")
    fun ApiServiceProvider(@Named("buildRetrofit") buildRetrofit:Retrofit)=
        buildRetrofit.create(DataCrmApiService::class.java)

}