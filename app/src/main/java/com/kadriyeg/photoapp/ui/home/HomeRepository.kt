package com.kadriyeg.photoapp.ui.home

import com.kadriyeg.photoapp.base.BaseFragment
import com.kadriyeg.photoapp.base.BaseRepository
import com.kadriyeg.photoapp.di.PhotoApp
import com.kadriyeg.photoapp.network.ApiFactory
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiFactory: ApiFactory):BaseRepository() {

    suspend fun getData() = safeApiRequest {
        apiFactory.getData()
    }

}