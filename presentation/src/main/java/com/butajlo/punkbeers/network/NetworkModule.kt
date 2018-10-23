package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.dao.PunkDaoImpl
import com.butajlo.punkbeers.data.service.PunkService
import com.butajlo.punkbeers.di.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module(includes = [ServiceModule::class, InterceptorsModule::class])
object NetworkModule {

    @AppScope
    @JvmStatic
    @Provides
    fun provideOkHttpClient(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {

        return OkHttpClient.Builder()
                .apply {
                    interceptors.forEach { addInterceptor(it) }
                }
                .build()
    }

    @AppScope
    @JvmStatic
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("base_url") baseUrl: String): Retrofit =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(baseUrl)
                    .build()

    @AppScope
    @JvmStatic
    @Provides
    fun providePunkService(retrofit: Retrofit): PunkService = retrofit.create(PunkService::class.java)

    @AppScope
    @JvmStatic
    @Provides
    fun providePunkDao(punkService: PunkService): PunkDao = PunkDaoImpl(punkService)


}