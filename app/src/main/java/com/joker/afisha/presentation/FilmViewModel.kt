package com.joker.afisha.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joker.afisha.data.network.entities.Film
import com.joker.afisha.domain.repository.FilmsRepository
import kotlinx.coroutines.launch

class FilmViewModel(private var filmsRepository: FilmsRepository) : ViewModel() {

    private var _film: MutableLiveData<Film> = MutableLiveData<Film>()
    var film: LiveData<Film> = _film as LiveData<Film>

    fun getFilm(id: String) {

        viewModelScope.launch {
            val res = filmsRepository.getFilm(id)
            res.onSuccess {
                _film.postValue(it)
                Log.d("OLOLO", "postValue")
            }
            res.onFailure {
                Log.d("OLOLO", it.message.toString())
            }
        }
        //  return allEvents
    }


}