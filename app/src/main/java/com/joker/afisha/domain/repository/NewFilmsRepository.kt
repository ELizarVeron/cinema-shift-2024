package com.joker.afisha.domain.repository

import com.joker.afisha.data.network.responses.FilmDetailsResponse
import com.joker.afisha.data.network.responses.FilmsResponse
import retrofit2.Response

interface NewFilmsRepository {

	suspend fun getAll(): Response<FilmsResponse>

	suspend fun getById(id: String): Response<FilmDetailsResponse>
}