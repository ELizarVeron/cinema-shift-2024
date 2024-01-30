package com.joker.afisha.data.core.network.entities.responses

import com.joker.afisha.data.network.entities.Film

data class FilmsResponse(
    val success: Boolean,
    val reason: String,
    val films: List<Film>
)