package com.joker.afisha.data.network.core


import com.joker.afisha.data.core.network.requests.CancelOrderRequest
import com.joker.afisha.data.core.network.requests.CreateOtpRequest
import com.joker.afisha.data.core.network.entities.responses.FilmDetailsResponse
import com.joker.afisha.data.network.responses.FilmsResponse
import com.joker.afisha.data.core.network.requests.PaymentRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path



interface RetrofitServices {

    @GET("/cinema/today")
    suspend fun getFilms(): Response<FilmsResponse>

    @GET("/cinema/film/{filmId}")
    suspend fun getFilmDetails(@Path("filmId") filmId: String): Response<FilmDetailsResponse>


    @PUT("/cinema/orders/cancel")
    suspend fun cancelOrder(@Body request: CancelOrderRequest): Response<com.joker.afisha.data.core.network.entities.responses.CancelOrderResponse>

    @GET("/cinema/film/{filmId}/schedule")
    suspend fun getFilmSchedule(@Path("filmId") filmId: String): Response<com.joker.afisha.data.core.network.entities.responses.FilmScheduleResponse>

    @POST("/cinema/payment")
    suspend fun makePayment(@Body request: PaymentRequest): Response<com.joker.afisha.data.core.network.entities.responses.PaymentResponse>

    @GET("/cinema/orders")
    suspend fun getAllOrders(@Header("Authorization") authorization: String): Response<com.joker.afisha.data.core.network.entities.responses.OrdersResponse>

    @POST("/auth/otp")
    suspend fun createOtp(@Body request: CreateOtpRequest): Response<com.joker.afisha.data.core.network.entities.responses.CreateOtpResponse>
}

