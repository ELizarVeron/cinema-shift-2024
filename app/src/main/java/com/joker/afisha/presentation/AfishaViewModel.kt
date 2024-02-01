package com.joker.afisha.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joker.afisha.data.network.entities.Film
import com.joker.afisha.domain.repository.NewFilmsRepository
import kotlinx.coroutines.launch

class AfishaViewModel(private val newFilmsRepository: NewFilmsRepository) : ViewModel() {

    private val _films: MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()
    val films: LiveData<List<Film>> = _films
    init {
        getAllFilms()
    }
    private fun getAllFilms() {
        viewModelScope.launch {
           val response = newFilmsRepository.getAll()

            _films.value = response.body()?.films
        }
    }


}