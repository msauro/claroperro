package com.example.claroperro.repository

import com.example.claroperro.Dog
import com.example.claroperro.DogImage
import com.example.claroperro.api.ApiResponseStatus
import com.example.claroperro.api.DTO.DogDTOMapper
import com.example.claroperro.api.DogApi.retrofitService
import com.example.claroperro.api.makeNetworkCall

class DogRepository {
    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>>{
        return makeNetworkCall {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogListApiResponse)
        }

    }

    suspend fun downloadDogsImg(dogImg: String): ApiResponseStatus<DogImage>{
        return makeNetworkCall {
            val dogUrlApiResponse = retrofitService.getImg(dogImg)
            //val dogImage = dogUrlApiResponse.url
            dogUrlApiResponse
        }

    }

}