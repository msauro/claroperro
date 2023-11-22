package com.example.claroperro.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.claroperro.Dog
import com.example.claroperro.api.ApiResponseStatus
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>>
        get()= _dogList

    private val _status = MutableLiveData<ApiResponseStatus>()
    val status: LiveData<ApiResponseStatus>
        get()= _status

    private val dogRepository = DogRepository()
    init{
        downloadDogs()
    }

    private fun downloadDogs(){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus (dogRepository.downloadDogs())
        }
    }

    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus) {
        if(apiResponseStatus is ApiResponseStatus.Succes){
            _dogList.value = apiResponseStatus.dogList
        }

        _status.value = apiResponseStatus
    }
}