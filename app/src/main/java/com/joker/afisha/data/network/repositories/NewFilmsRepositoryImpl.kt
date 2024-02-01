package com.joker.afisha.data.network.repositories

import com.joker.afisha.data.network.FilmsDataSource
import com.joker.afisha.data.network.responses.FilmDetailsResponse
import com.joker.afisha.data.network.responses.FilmsResponse
import com.joker.afisha.domain.repository.NewFilmsRepository
import retrofit2.Response

class NewFilmsRepositoryImpl(private val dataSource: FilmsDataSource) : NewFilmsRepository {

	override suspend fun getAll(): Response<FilmsResponse> = dataSource.getAll()

	override suspend fun getById(id: String): Response<FilmDetailsResponse> = dataSource.getById(id)
}