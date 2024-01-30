package com.joker.afisha.data.core.network.entities.responses

import com.joker.afisha.data.network.entities.Order

data class OrdersResponse(
    val success: Boolean,
    val reason: String,
    val orders: List<Order>
)