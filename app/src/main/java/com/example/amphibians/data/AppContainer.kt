package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansInfoService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer {// returns the repository after building and all
    val amphibianRepository : AmphibianRepository
}

class DefaultAppContainer : AppContainer{
    val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/amphibians/"

    // build retrofit
    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    // use retrofit to make a service
    val retrofitService : AmphibiansInfoService by lazy { retrofit.create( AmphibiansInfoService::class.java ) }
    // the service is created lazily. i.e when needed. just pass the service class lambda so retrofit can use it later

    // provide the service to the repository
    override val amphibianRepository: AmphibianRepository by lazy { AmphibianNetworkRepository(retrofitService) }
}