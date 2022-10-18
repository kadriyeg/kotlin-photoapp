package com.kadriyeg.photoapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kadriyeg.photoapp.model.home.CatResponse
import com.kadriyeg.photoapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val imageResponse: MutableLiveData<CatResponse?> = MutableLiveData()
    val isLoading : MutableLiveData<Boolean> = MutableLiveData()
    val onError : MutableLiveData<String?> = MutableLiveData()

    fun getData(

    ) = viewModelScope.launch {
        isLoading.value = true
        val request = repository.getData()
        when(request){
            is NetworkResult.Success -> {
                imageResponse.value = request.data
            }
            is NetworkResult.Error -> {
                onError.value = request.message
                isLoading.value = false
            }
            else -> {}
        }

    }

}