package com.yelloco.movieapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yelloco.movieapp.R
import com.yelloco.movieapp.callbacks.diffs.MovieDiffCallback
import com.yelloco.movieapp.enums.Constants
import com.yelloco.movieapp.retrofit.models.MovieModel

class MoviesAdapter : ListAdapter<MovieModel, MoviesAdapter.MovieViewHolder>(MovieDiffCallback()) {

    private val classTag = this.javaClass.simpleName

    var movies: MutableList<MovieModel> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        movies[position].let {
            val imageURL = Constants.IMAGE_NORMAL_BASE_URL.constant + it.posterImage
            Log.i(classTag, "Image URL: $imageURL")
            Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.image_not_found)
                .into(holder.movieImageView)

            val name = if(it.name.length > 18) {
                "${it.name.substring(0, 18)}..."
            } else {
                it.name
            }
            holder.movieTitleTextView.text = name
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val movieImageView : ImageView =
            itemView.findViewById(R.id.list_item_movie_image_view)
        val movieTitleTextView : TextView =
            itemView.findViewById(R.id.list_item_movie_text_view)
    }
}