package com.joker.afisha.di

import com.joker.afisha.data.network.core.RetrofitServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://shift-backend.onrender.com"

val NetworkModule = module {

	singleOf(::provideLoggingInterceptor)
	singleOf(::provideOkHttpClient)
	singleOf(::provideGsonConverterFactory)
	singleOf(::provideRetrofit)
	singleOf(::provideRetrofitServices)
}

private fun provideLoggingInterceptor() =
	HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
	.addInterceptor(loggingInterceptor)
	.build()

private fun provideGsonConverterFactory() =
	GsonConverterFactory.create()

private fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory) =
	Retrofit.Builder()
		.baseUrl(BASE_URL)
		.addConverterFactory(gsonConverterFactory)
		.client(okHttpClient)
		.build()

private fun provideRetrofitServices(retrofit: Retrofit) =
	retrofit.create(RetrofitServices::class.java)