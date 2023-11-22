package com.example.claroperro.doglist

import com.example.claroperro.Dog
import com.example.claroperro.R
import com.example.claroperro.api.ApiResponseStatus
import com.example.claroperro.api.DTO.DogDTOMapper
import com.example.claroperro.api.DogApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {
    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>>{
        return withContext(Dispatchers.IO){
            try {
                val dogListApiResponse = retrofitService.getAllDogs()
                //val dogDTOList = dogListApiResponse
                val dogDTOMapper = DogDTOMapper()
                ApiResponseStatus.Success(dogDTOMapper.fromDogDTOListToDogDomainList(dogListApiResponse))
            } catch (e: UnknownHostException){
                ApiResponseStatus.Error(R.string.unknow_host_exception_error)
            } catch (e: Exception){
                ApiResponseStatus.Error(R.string.unknow_error)
            }
        }
    }

}