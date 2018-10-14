package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.dao.PunkDaoImpl
import com.butajlo.punkbeers.data.service.PunkService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkModule {

    @NetworkScope
    @JvmStatic
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
    }

    @NetworkScope
    @JvmStatic
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("base_url") baseUrl: String): Retrofit =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(baseUrl)
                    .build()

    @NetworkScope
    @JvmStatic
    @Provides
    @Named("base_url")
    fun provideApiUrl() = "https://api.punkapi.com/v2/"

    @NetworkScope
    @JvmStatic
    @Provides
    fun providePunkService(retrofit: Retrofit): PunkService
            = retrofit.create(PunkService::class.java)

    @NetworkScope
    @JvmStatic
    @Provides
    fun providePunkDao(punkService: PunkService): PunkDao = PunkDaoImpl(punkService)


}