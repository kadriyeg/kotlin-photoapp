package com.kadriyeg.photoapp.network

import com.kadriyeg.photoapp.model.home.CatResponse
import retrofit2.http.GET

interface ApiFactory {

    //https://api.thecatapi.com/v1/images/search

    @GET("v1/images/search")
    suspend fun getData(): CatResponse
}