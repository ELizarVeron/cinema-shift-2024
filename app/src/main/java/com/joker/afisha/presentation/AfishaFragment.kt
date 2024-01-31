package com.joker.afisha.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.joker.afisha.R
import com.joker.afisha.databinding.FragmentAfishaBinding
import com.joker.afisha.presentation.adapters.FilmsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates


class AfishaFragment : Fragment(R.layout.fragment_afisha) {
    private var binding: FragmentAfishaBinding by Delegates.notNull()
    private val viewModel by viewModel<AfishaViewModel>()
    private var filmsAdapter: FilmsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentAfishaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createRecycler()

        viewModel.films.observe(viewLifecycleOwner){ films ->
            if(films.isNotEmpty()){
                filmsAdapter?.itemList = films
                films.forEach{
                    Log.d("OLOLO",it.toString())

                    Log.d("OLOLO", it.toString())

                }
            }



        }

    }

    private fun createRecycler() {
        filmsAdapter = FilmsAdapter(requireContext(),
            //ф-я клика по кнопке действия
            fun(id: String) {
                val bundle = bundleOf("id" to id)
                requireView().findNavController()
                    .navigate(R.id.action_afisha_to_filmFragment, bundle)

                val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)

                // Скрыть BottomNavigationView
                bottomNavigationView?.visibility = View.GONE
            })

        binding.rvFilms.setHasFixedSize(true)
        binding.rvFilms.setItemViewCacheSize(50);

        val layoutManager = LinearLayoutManager(activity)
        binding.rvFilms.layoutManager = layoutManager
        binding.rvFilms.setPadding(10, 30, 10, 30)
        binding.rvFilms.adapter = filmsAdapter
    }

}