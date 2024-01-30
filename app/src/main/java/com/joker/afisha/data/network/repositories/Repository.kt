package com.joker.afisha.data.network.repositories

import com.joker.afisha.domain.entities.Film
import com.joker.afisha.domain.repository.Repo
import kotlinx.coroutines.flow.Flow

class Repository: Repo {
     override fun getAllFilms(): Flow<Film> {
        TODO("Not yet implemented")
    }
}