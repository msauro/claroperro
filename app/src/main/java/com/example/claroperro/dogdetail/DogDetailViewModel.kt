package com.example.claroperro.dogdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.claroperro.DogImage
import com.example.claroperro.api.ApiResponseStatus
import com.example.claroperro.repository.DogRepository
import kotlinx.coroutines.launch


class DogDetailViewModel: ViewModel() {

    private val _dogImg = MutableLiveData<DogImage>()
    val dogImg: LiveData<DogImage>
        get()= _dogImg

    private val _status = MutableLiveData<ApiResponseStatus<DogImage>>()
    val status: LiveData<ApiResponseStatus<DogImage>>
        get()= _status

    private val dogRepository = DogRepository()

     fun downloadDogsImg(dogImg: String){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus (dogRepository.downloadDogsImg(dogImg))
        }
    }

    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus<DogImage>) {
        if(apiResponseStatus is ApiResponseStatus.Success){
            _dogImg.value = apiResponseStatus.data
        }

        _status.value = apiResponseStatus
    }
}
