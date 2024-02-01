package com.joker.afisha.di

import com.joker.afisha.data.network.FilmsDataSource
import com.joker.afisha.data.network.FilmsDataSourceImpl
import com.joker.afisha.data.network.repositories.FilmsRepositoryImpl
import com.joker.afisha.data.network.repositories.NewFilmsRepositoryImpl
import com.joker.afisha.domain.repository.FilmsRepository
import com.joker.afisha.domain.repository.NewFilmsRepository
import com.joker.afisha.presentation.AfishaViewModel
import com.joker.afisha.presentation.FilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
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


	singleOf(::FilmsDataSourceImpl) { bind<FilmsDataSource>() }
    singleOf(::NewFilmsRepositoryImpl) { bind<NewFilmsRepository>() }
}


