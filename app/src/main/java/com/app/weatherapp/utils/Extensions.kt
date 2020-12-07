package com.app.weatherapp.utils

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException

object Extensions {
    private val TAG = Extensions.javaClass.name

    fun CoroutineScope.launchSafely(
        block: suspend () -> Unit,
        error: (e: Exception) -> Unit = {},
    ): Job {
        return launch {
            try {
                block()
            } catch (jobCancelException: CancellationException) {
                Log.e(TAG, jobCancelException.toString())
            } catch (exp: Exception) {
                Log.e(TAG, exp.localizedMessage)
                error(exp)
            }
        }
    }


    suspend fun <T : Any> handleRequestNew(requestFunc: suspend () -> T): Try<T> {
        return try {
            Try.success(requestFunc.invoke())
        } catch (e: HttpException) {
            val errorMsg = getErrorMessageFromGenericResponse(e)
            if (errorMsg.isNotEmpty()) {
                Try.failure(Exception(errorMsg))
            } else {
                Try.failure(e)
            }
        } catch (e: Exception) {
            Try.failure(e)
        }
    }

    private fun getErrorMessageFromGenericResponse(httpException: HttpException): String {
        var errorMessage = ""
        try {
            val body = httpException.response()?.errorBody()
            errorMessage = body.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return errorMessage
        }
    }

}
