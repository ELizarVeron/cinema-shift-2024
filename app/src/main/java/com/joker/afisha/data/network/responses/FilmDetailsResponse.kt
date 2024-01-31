package com.joker.afisha.data.network.responses

import com.joker.afisha.data.network.entities.Film
import com.joker.afisha.data.network.entities.Schedule

data class FilmDetailsResponse(
    val success: Boolean,
    val reason: String,
    val film: Film
)