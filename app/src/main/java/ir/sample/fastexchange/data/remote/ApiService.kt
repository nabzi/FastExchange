package ir.sample.fastexchange.data.remote

import ir.sample.fastexchange.model.ExchangeRates
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search/2/nearbySearch/.json")
    suspend  fun getExchangeRates(@Query("search")search : String ) :Response<ExchangeRates>
}