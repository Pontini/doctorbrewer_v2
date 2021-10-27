package pontinisystems.network

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

abstract class BaseDataSource {

    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> T,
        retry: Int = 0
    ): T {
        do {
            return try {
                val myObject = withContext(Dispatchers.IO) { apiCall.invoke() }
                myObject
            } catch (throwable: Exception) {
                if (retry <= 0) {
                    throw handleError(throwable)
                } else {
                    safeApiCall(apiCall = apiCall, retry = (retry - 1))
                }
            }

        } while (retry > 0)


    }

    private fun handleError(throwable: Exception): Exception = when (throwable) {
        is IOException -> throw  CustomException.Network()
        is HttpException -> {
            val code = throwable.code()
            val errorResponse = convertErrorBody(throwable)
            throw CustomException.ResponseBodyError(errorResponse)
        }
        else -> {
           throw  CustomException.Unknown(throwable)
        }
    }

    private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
        try {
            throwable.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Gson().getAdapter(ErrorResponse::class.java)
                return moshiAdapter.fromJson(it.toString())
            }
        } catch (exception: Exception) {
            return null
        }
        return null
    }
}