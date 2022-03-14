package ir.sample.fastexchange.data.remote

import ir.sample.fastexchange.model.ExchangeRates
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("latest")
    suspend fun getExchangeRates(@Query("access_key")apiKey : String, @Query("symbols") currencies: List<String>)
            : Response<ExchangeRates>
}