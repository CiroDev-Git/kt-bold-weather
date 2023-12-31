package com.cirodev.boldweatherapi.di

import com.cirodev.boldweatherapi.BuildConfig
import com.cirodev.boldweatherapi.SettingsManager
import com.cirodev.boldweatherapi.data.api.location.request.LocationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(
        settingsManager: SettingsManager
    ): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(
                Interceptor { chain ->
                    val lang = runBlocking {
                        settingsManager.getConfig(SettingsManager.LANG_KEY).first()
                    }

                    val url = chain.request().url.newBuilder()
                        .addQueryParameter("key", BuildConfig.WEATHER_API_KEY)
                    if (lang != null) {
                        url.addQueryParameter("lang", lang)
                    }
                    return@Interceptor chain.proceed(
                        chain.request().newBuilder().url(url.build()).build()
                    )
                }
            )
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.WEATHER_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun providesLocationApi(retrofit: Retrofit): LocationApi =
        retrofit.create(LocationApi::class.java)

}