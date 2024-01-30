package com.joker.afisha.data.network.entities

import com.joker.afisha.data.network.entities.Hall
import com.joker.afisha.data.network.entities.PayedTicket

data class Seance(
    val time: String,
    val hall: Hall,
    val payedTickets: List<PayedTicket>
)