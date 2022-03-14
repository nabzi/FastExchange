package ir.sample.fastexchange.data.repository

import ir.sample.fastexchange.model.Resource
import ir.sample.fastexchange.model.Status
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *   NetworkCall<ResultType> is an abstract class that can be used for api calls.
 *   It manages error cases and returns proper error message and error code
 *   */
abstract class NetworkCall<ResultType> {
    suspend fun fetch(): Resource<ResultType> {
        return try {
            val response = createCall()
            if (response.isSuccessful) {
                onSuccess(response.body())
                Resource(
                    Status.SUCCESS,
                    response.body(),
                    "success"
                )

            } else{
                val errorMsg = response.errorBody()?.let {
                    JSONObject(it.charStream().readText()).getString("message")
                }

                Resource.error(errorMsg?:"" ,null, response.code())
            }

        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.error(e.message(), null, e.code())

        } catch (e: ConnectException) {
            e.printStackTrace()
            Resource.error("Network Connection error",null,
                ConnectException
            )

        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
            Resource.error( "Network Connection error",null,
                SocketTimeoutException
            )

        }catch (e : UnknownHostException){
            e.printStackTrace()
            Resource.error("Network Connection error",null,
                UnknownHostException
            )

        }catch (e : JSONException){
            e.printStackTrace()
            Resource.error("JSONException",null,
                JSONException
            )

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.error(e.message.toString(),null,
                Exception
            )
        }
    }

    abstract suspend fun createCall(): Response<ResultType>
    open suspend fun onSuccess(result: ResultType?){}
    companion object{
         const val ConnectException=600
         const val SocketTimeoutException=601
         const val UnknownHostException=602
         const val Exception=603
         const val JSONException=604
    }
}