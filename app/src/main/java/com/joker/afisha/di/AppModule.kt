package com.joker.afisha.di


import com.joker.afisha.data.network.repositories.FilmsRepositoryImpl
import com.joker.afisha.domain.repository.FilmsRepository
import com.joker.afisha.presentation.AfishaViewModel
import com.joker.afisha.presentation.FilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val AppModule = module {


    viewModel {
        AfishaViewModel(filmsRepository = get())
    }
    viewModel {
        FilmViewModel(filmsRepository = get())
    }
    single<FilmsRepository> {
        FilmsRepositoryImpl()
    }


}


