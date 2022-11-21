package com.example.mymoveapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MovieData
import kotlinx.android.synthetic.main.move_item.view.*

class PagingMovieAdapter(
    val itemClick: (MovieData) -> Unit
) : PagingDataAdapter<MovieData, PagingMovieAdapter.MovieViewHolder>(MovieComparator) {

    private val moveList = mutableListOf<MovieData>()
    private val imgBaseUrl = "https://image.tmdb.org/t/p/original"

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(move: MovieData, position: Int) {
            itemView.imgLief.setOnClickListener {
                itemClick(move)
            }
            itemView.tvTextYear.text = getItem(position)!!.originalLanguage
            itemView.tvTextName.text = getItem(position)!!.title
            Glide.with(itemView.context)
                .load(imgBaseUrl + move.posterPath)
                .into(itemView.imgLief)
        }
    }
    override fun onBindViewHolder(holder: PagingMovieAdapter.MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, position) }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PagingMovieAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.move_item, parent, false)
        return MovieViewHolder(view)
    }

    fun update(list: List<MovieData>) {
        moveList.clear()
        moveList.addAll(list)
        notifyDataSetChanged()
    }

    object MovieComparator : DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem == newItem
        }

    }

}

//        holder.bind(moveList[position],position)