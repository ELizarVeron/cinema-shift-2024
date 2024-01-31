package com.joker.afisha.data.network.repositories

import com.joker.afisha.data.network.core.RetrofitClient
import com.joker.afisha.data.network.core.RetrofitServices
import com.joker.afisha.data.network.entities.Film
import com.joker.afisha.domain.repository.Repo

class RepositoryImpl: Repo {
    private val rService: RetrofitServices = RetrofitClient.instance
     override suspend fun getAllFilms(): Result<List<Film>?> =
         try {
             val response = rService.getFilms()
             if(response.isSuccessful){
                 if(response.body()?.success==true){
                     Result.success(response.body()?.films)
                 } else{
                     Result.failure(Exception(response.body()?.reason?:"unknown error"))
                 }

             } else{
                 Result.failure(Exception(response.message()))
             }

         } catch (e: Exception) {
             Result.failure(e)
         }

    override suspend fun getFilm(id:String): Result<Film?> =
        try {
            val response = rService.getFilmDetails(id)
            if(response.isSuccessful){
                if(response.body()?.success==true){
                    Result.success(response.body()?.film)
                } else{
                    Result.failure(Exception(response.body()?.reason?:"unknown error"))
                }

            } else{
                Result.failure(Exception(response.message()))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }


}