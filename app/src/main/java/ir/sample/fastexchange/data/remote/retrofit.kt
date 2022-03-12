package ir.sample.fastexchange.data.remote

import ir.sample.fastexchange.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://api.exchangeratesapi.io/latest?access_key=2199a3331c976c2a3c03fcb0852b8b14"
const val API_KEY = ""

fun createHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    return okHttpClientBuilder.build()
}

fun createRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

