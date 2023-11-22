package com.example.claroperro.api

import com.example.claroperro.Dog

sealed class ApiResponseStatus {
    class Succes(val dogList: List<Dog>): ApiResponseStatus()
    class Loading(): ApiResponseStatus()
    class Error(val message: Int): ApiResponseStatus()
}