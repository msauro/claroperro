package com.example.claroperro.doglist

import com.example.claroperro.Dog
import com.example.claroperro.api.DTO.DogDTOMapper
import com.example.claroperro.api.DogApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog>{
        return withContext(Dispatchers.IO){
            val dogListApiResponse = retrofitService.getAllDogs()
            //val dogDTOList = dogListApiResponse
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogListApiResponse)
        }
    }

}