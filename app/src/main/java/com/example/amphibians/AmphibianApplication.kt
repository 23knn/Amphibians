package com.example.amphibians

import android.app.Application
import com.example.amphibians.data.AppContainer
import com.example.amphibians.data.DefaultAppContainer

class AmphibianApplication : Application() {
    lateinit var container : AppContainer // lateinit is just because you have to initialize, i.e give a value to the var. so lateinit allows you to do it later..
    //..we have to declare here to make it a global var for the app. and we have to initialize later because the default onCreate() must run before we initialize this
    override fun onCreate() {
        super.onCreate() // first runs the creation process as normal
        container = DefaultAppContainer() // but also adds the container as one of the variables of the whole app
    }
}