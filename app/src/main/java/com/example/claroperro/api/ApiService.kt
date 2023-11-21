package com.example.claroperro.api


import com.example.claroperro.BASE_URL
import com.example.claroperro.GET_ALL_DOGS_URL
import com.example.claroperro.api.DTO.DogDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ApiService{
     @GET(GET_ALL_DOGS_URL)
     suspend fun getAllDogs(): List <DogDTO>
}

object DogApi{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}