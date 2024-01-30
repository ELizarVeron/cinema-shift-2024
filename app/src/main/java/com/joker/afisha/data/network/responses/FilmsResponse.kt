package com.joker.afisha.data.network.responses

import com.joker.afisha.data.network.entities.Film

data class FilmsResponse(
    val success: Boolean,
    val reason: String,
    val films: List<Film>
)