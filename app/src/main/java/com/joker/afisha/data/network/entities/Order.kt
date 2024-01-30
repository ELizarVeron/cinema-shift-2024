package com.joker.afisha.data.network.entities

import com.joker.afisha.data.network.entities.PayedTicket

data class Order(
    val filmName: String,
    val orderNumber: Int,
    val tickets: List<PayedTicket>,
    val phone: String,
    val status: String
)