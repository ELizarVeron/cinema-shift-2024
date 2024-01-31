package com.joker.afisha.domain.repository


import com.joker.afisha.data.network.entities.Film

interface FilmsRepository {
    suspend fun getAllFilms(): Result<List<Film>?>
    suspend fun getFilm(id:String): Result<Film?>
}