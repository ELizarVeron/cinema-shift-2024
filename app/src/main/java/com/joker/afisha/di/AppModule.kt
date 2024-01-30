package com.joker.afisha.di


import com.joker.afisha.data.network.core.RetrofitServices
import com.joker.afisha.data.network.repositories.RepositoryImpl
import com.joker.afisha.domain.repository.Repo
import com.joker.afisha.presentation.AfishaViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT: Long = 30
private const val BASE_URL = "https://shift-backend.onrender.com/"
val AppModule = module {


  /*  single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServices::class.java)

    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(interceptor = get())
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()

    }
    single<okhttp3.Interceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

    }*/

    viewModel {
        AfishaViewModel(repo = get())
    }

    single<Repo> {
        RepositoryImpl()
    }


}


