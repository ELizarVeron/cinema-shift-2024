package com.joker.afisha.data.network.entities

data class PayedTicket(
    val filmId: String,
    val row: Int,
    val column: Int,
    val seance: SeanceInfo,
    val phone: String
)