package com.joker.afisha.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.joker.afisha.data.network.core.RetrofitClient
import com.joker.afisha.data.network.entities.Film
import com.joker.afisha.databinding.FilmItemBinding

import java.time.format.TextStyle
import java.util.Locale


class FilmsAdapter(
    private val context: Context,
    private val onButtonClick: (String) -> Unit
) :
    RecyclerView.Adapter<FilmsAdapter.EventsViewHolder>() {

    var itemList: List<Film> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return EventsViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size ?: 0
    }


    inner class EventsViewHolder(
        private val eventItemBinding: FilmItemBinding,
        val context: Context
    ) :
        RecyclerView.ViewHolder(eventItemBinding.root) {

        fun bind(item: Film) {
            val id = itemList[adapterPosition].id
            eventItemBinding.see.setOnClickListener {
                onButtonClick(id)
            }
            eventItemBinding.title.text = item.name
            eventItemBinding.subTitle.text = item.originalName

            Glide.with(context)
                .load(RetrofitClient.BASE_URL+item.img)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into( eventItemBinding.imFilm)





        }


    }
}

