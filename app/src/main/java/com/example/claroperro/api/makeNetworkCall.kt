package com.example.claroperro.api

import com.example.claroperro.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend () -> T //como es una llamada a internet tiene que ser SUSPEND
): ApiResponseStatus<T> {
    return withContext(Dispatchers.IO){
        try {
            ApiResponseStatus.Success(call())
        } catch (e: UnknownHostException){
            ApiResponseStatus.Error(R.string.unknow_host_exception_error)
        } catch (e: Exception){
            ApiResponseStatus.Error(R.string.unknow_error)
        }
    }
}