package com.joker.afisha.data.core.network.requests

import com.joker.afisha.data.network.entities.DebitCard
import com.joker.afisha.data.network.entities.Person
import com.joker.afisha.data.network.entities.SeanceInfo
import com.joker.afisha.data.network.entities.Ticket

data class PaymentRequest(
    val filmId: String,
    val person: Person,
    val debitCard: DebitCard,
    val seance: SeanceInfo,
    val tickets: List<Ticket>
)