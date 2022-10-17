package com.umain.home

import retrofit2.HttpException

suspend fun <T : Any> handleRequest(requestFunc: suspend () -> T): Result<T> {
    return try {
        Result.success(requestFunc.invoke())
    } catch (e: HttpException) {
        when {
            e.code() == 400 -> Result.failure(Throwable("user not found"))
            else -> Result.failure(e)
        }
    }
}
