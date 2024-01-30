package com.joker.afisha.data.core.network.entities.responses

import com.joker.afisha.data.network.entities.Schedule

data class FilmDetailsResponse(
    val success: Boolean,
    val reason: String,
    val schedules: List<Schedule>
)