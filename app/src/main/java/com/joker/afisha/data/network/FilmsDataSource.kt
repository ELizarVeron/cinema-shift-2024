package com.joker.afisha.data.network

import com.joker.afisha.data.network.core.RetrofitServices
import com.joker.afisha.data.network.responses.FilmDetailsResponse
import com.joker.afisha.data.network.responses.FilmsResponse
import retrofit2.Response

interface FilmsDataSource {

	suspend fun getAll(): Response<FilmsResponse>

	suspend fun getById(id: String): Response<FilmDetailsResponse>
}

class FilmsDataSourceImpl(private val retrofitServices: RetrofitServices) : FilmsDataSource {

	override suspend fun getAll(): Response<FilmsResponse> = retrofitServices.getFilms()

	override suspend fun getById(id: String): Response<FilmDetailsResponse> = retrofitServices.getFilmDetails(id)
}