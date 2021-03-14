package com.yelloco.movieapp.callbacks.diffs

import androidx.recyclerview.widget.DiffUtil
import com.yelloco.movieapp.retrofit.models.MovieModel

class MovieDiffCallback : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.movieId == newItem.movieId
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.name.equals(newItem.name, true) &&
                oldItem.releaseDate.equals(newItem.releaseDate, true)
    }
}