package com.example.amphibians.data

import com.example.amphibians.models.Amphibian
import com.example.amphibians.network.AmphibiansInfoService

interface AmphibianRepository {
    suspend fun getAmphibians() : List<Amphibian>
}

class AmphibianNetworkRepository (private val retrofitService : AmphibiansInfoService) : AmphibianRepository{
    override suspend fun getAmphibians() : List<Amphibian> = retrofitService.getAmphibians()
    // we're equating the first function to the second. so when the first is called, it calls the second. i.e the first returns what the second returns
}