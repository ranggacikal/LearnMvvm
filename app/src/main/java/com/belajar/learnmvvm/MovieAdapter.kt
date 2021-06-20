package com.belajar.learnmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.belajar.learnmvvm.databinding.ItemRowMovieBinding
import com.belajar.learnmvvm.model.ResultsItem
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private  val listMovie = ArrayList<ResultsItem>()

    fun setMovies(movies : List<ResultsItem>?){
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder {
        val binding = ItemRowMovieBinding.inflate(LayoutInflater.
        from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyViewHolder, position: Int) {
        val item = listMovie[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listMovie.size

    inner class MyViewHolder(private val binding : ItemRowMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : ResultsItem){
            with(binding){
                tvItemOverview.text = item.overview
                tvItemTitle.text = item.title
                tvItemReleaseDate.text = item.releaseDate
                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${item.posterPath}")
                    .error(R.drawable.ic_launcher_background).into(imgItemPoster)
            }
        }
    }
}