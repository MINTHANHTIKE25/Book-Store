package com.minthanhtike.bookstores.data.utils

import android.util.Log
import com.minthanhtike.bookstores.data.exceptions.ApiException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <reified T> handle(
    crossinline apiCall: suspend () -> HttpResponse
): Result<T> {
    return withContext(Dispatchers.IO) {
        try {
            val httpResponse = apiCall()
            when (httpResponse.status) {
                //200
                HttpStatusCode.OK -> {
                    //Success?
                    val response: T = httpResponse.body<T>()
//                    if (response != null) {
                        Result.success(response)
//                    }
                    //Fail or Success?
//                    Result.failure(
//                        ApiException(
//                            code = httpResponse.status.value,
//                            message = "Something went wrong"
//                        )
//                    )
                }

                //404
                HttpStatusCode.NotFound -> Result.failure(
                    ApiException(
                        code = httpResponse.status.value,
                        message = "NEW_USER"
                    )
                )

                else -> {
                    Log.d("WHATEXCEPTION", "handle: ${httpResponse.bodyAsText() ?: "An Unknown Error"}")
                    Result.failure(
                        ApiException(
                            code = httpResponse.status.value,
                            message = "Something went wrong"
                        )
                    )
                }
            }
        } catch (e: Exception) {
            Log.d("WHATEXCEPTION", "handle: ${e.localizedMessage ?: "An Unknown Error"}")
            //Fail or Success?
            Result.failure(e)
        }
    }

}