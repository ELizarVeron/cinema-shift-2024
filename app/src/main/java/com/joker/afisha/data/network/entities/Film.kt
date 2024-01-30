package com.joker.afisha.data.network.entities

import com.joker.afisha.data.network.entities.Actor
import com.joker.afisha.data.network.entities.Country
import com.joker.afisha.data.network.entities.Director
import com.joker.afisha.data.network.entities.UserRatings


data class Film(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<Actor>,
    val directors: List<Director>,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>,
    val userRatings: UserRatings,
    val img: String,
    val country: Country
)



