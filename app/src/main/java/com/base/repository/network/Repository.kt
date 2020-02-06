package com.base.repository.network

import retrofit2.HttpException

object Repository {


    suspend fun <T : Any> handleRequest(requestFunc: suspend () -> T): Result<T> {
        return try {
            Result.success(requestFunc.invoke())
        } catch (httpException: HttpException) {
                Result.failure(httpException)
        } catch (e: Exception) {
            Result.failure(Throwable(e.message))
        }
    }

}