package com.joker.afisha.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.joker.afisha.R
import com.joker.afisha.data.network.core.RetrofitClient
import com.joker.afisha.data.network.entities.Film
import com.joker.afisha.databinding.FragmentFilmBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates


class FilmFragment : Fragment() {
    private var binding: FragmentFilmBinding by Delegates.notNull()
    private val viewModel by viewModel<FilmViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id")

        binding.imBack.setOnClickListener {
            requireView().findNavController()
                .popBackStack()
        }

        id?.let {
            viewModel.getFilm(it)
        }

        viewModel.film.observe(viewLifecycleOwner) {
            init(it)
        }

    }

    private fun init(film: Film) {
        binding.title.text = film.name
        binding.subTitle.text = film.originalName
        binding.about.text = film.description

        Glide.with(requireContext())
            .load(RetrofitClient.BASE_URL + film.img)
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
            .into(binding.imFilm)

    }

}