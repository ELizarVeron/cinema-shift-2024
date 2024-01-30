package com.joker.afisha.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joker.afisha.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class AfishaFragment : Fragment() {
    private val viewModel by viewModel<AfishaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_afisha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.films.observe(viewLifecycleOwner){ films ->
            films.forEach{
                Log.d("OLOLO",it.toString())
            }

        }

    }


}