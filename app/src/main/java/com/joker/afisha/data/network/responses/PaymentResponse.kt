package com.joker.afisha.data.core.network.entities.responses

import com.joker.afisha.data.network.entities.Order

// DTO (Data Transfer Object) для ответа от сервера при оплате билетов
data class PaymentResponse(
    val success: Boolean,
    val reason: String,
    val order: Order
)