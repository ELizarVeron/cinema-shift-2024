package com.joker.afisha.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joker.afisha.data.network.entities.Film
import com.joker.afisha.domain.repository.Repo
import kotlinx.coroutines.launch

class AfishaViewModel(private var repo: Repo) : ViewModel() {

    private var _films: MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()
    var films: LiveData<List<Film>> = _films as LiveData<List<Film>>
    init {
        getAllFilms()
    }
    private fun getAllFilms() {
        Log.d("OLOLO","getAllFilms")
        viewModelScope.launch {
           val res = repo.getAllFilms()
            res.onSuccess {
                _films.postValue(it)
                Log.d("OLOLO","postValue")
            }
            res.onFailure {
                Log.d("OLOLO",it.message.toString())
            }
        }
        //  return allEvents
    }


}