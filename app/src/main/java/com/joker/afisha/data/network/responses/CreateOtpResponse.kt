package com.joker.afisha.data.core.network.entities.responses

data class CreateOtpResponse(
    val success: Boolean,
    val reason: String,
    val retryDelay: Long
)