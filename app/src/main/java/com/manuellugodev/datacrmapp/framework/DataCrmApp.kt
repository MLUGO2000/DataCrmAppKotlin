package com.manuellugodev.datacrmapp.framework

import android.app.Application
import com.manuellugodev.datacrmapp.framework.di.AppComponent
import com.manuellugodev.datacrmapp.framework.di.DaggerAppComponent

class DataCrmApp:Application() {

    lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent=DaggerAppComponent.create()
    }
}