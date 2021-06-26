package com.belajar.learnmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.learnmvvm.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        movieViewModel.setMovie()

        val movieAdapter = MovieAdapter()

        movieViewModel.getMovie().observe(this, Observer {
            movieAdapter.setMovies(it)
            movieAdapter.notifyDataSetChanged()
        })

        with(binding.rvMovie){
            layoutManager = LinearLayoutManager(this@MovieActivity)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}