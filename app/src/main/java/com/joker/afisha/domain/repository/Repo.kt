package com.joker.afisha.domain.repository

import com.joker.afisha.domain.entities.Film
import kotlinx.coroutines.flow.Flow

interface Repo {
    fun getAllFilms(): Flow<Film>
}