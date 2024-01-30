package com.joker.afisha.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joker.afisha.domain.entities.Film

class AfishaViewModel : ViewModel() {

    private var _films: MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()
    var films: LiveData<List<Film>> = _films as LiveData<List<Film>>


}