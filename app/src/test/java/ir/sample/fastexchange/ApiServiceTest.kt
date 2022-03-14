package ir.sample.fastexchange

import ir.sample.fastexchange.data.remote.*
import ir.sample.fastexchange.data.repository.NetworkCall
import ir.sample.fastexchange.model.ExchangeRates
import ir.sample.fastexchange.model.Resource
import ir.sample.fastexchange.model.Status
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response


class ApiServiceTest {
    lateinit var apiServices: ApiService

    @Before
    fun setup() {
        apiServices = createService(createRetrofit(createHttpClient(), BASE_URL))
    }

    @Test
    fun getExchangeRates_success() = runBlocking {
        var result: Resource<ExchangeRates> = object : NetworkCall<ExchangeRates>() {
            override suspend fun createCall(): Response<ExchangeRates> {
                return apiServices.getExchangeRates(API_KEY , listOf("USD" , "BGP"))
            }
        }.fetch()
        assert(result.status == Status.SUCCESS)
    }
}
