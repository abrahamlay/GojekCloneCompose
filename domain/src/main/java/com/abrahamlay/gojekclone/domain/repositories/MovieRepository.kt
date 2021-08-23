package com.abrahamlay.gojekclone.domain.repositories

import com.abrahamlay.gojekclone.domain.entities.DetailMovieModel
import com.abrahamlay.gojekclone.domain.entities.MovieModel
import com.abrahamlay.gojekclone.domain.entities.ReviewModel
import com.abrahamlay.gojekclone.domain.entities.VideoModel
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-09-29.
 */

interface MovieRepository {
    fun getPopularMovies(apiKey: String): Flowable<List<com.abrahamlay.gojekclone.domain.entities.MovieModel>?>
    fun getTopRatedMovies(apiKey: String): Flowable<List<com.abrahamlay.gojekclone.domain.entities.MovieModel>?>
    fun getNowPlayingMovies(apiKey: String): Flowable<List<com.abrahamlay.gojekclone.domain.entities.MovieModel>?>
//    fun getFavoriteMovies(): Flowable<List<MovieModel>?>
//    fun getFavoriteMovie(movieId: Int): Flowable<MovieModel?>
//    fun insertFavoriteMovie(movieModel: MovieModel): Long
//    fun deleteFavoriteMovie(movieModel: MovieModel): Int
    fun getReviews(
        apiKey: String,
        movieId: Int
    ): Flowable<List<com.abrahamlay.gojekclone.domain.entities.ReviewModel>>

    fun getVideo(
        apiKey: String,
        movieId: Int
    ): Flowable<List<com.abrahamlay.gojekclone.domain.entities.VideoModel>>

    fun getMovieDetails(
        apiKey: String,
        movieId: Int
    ): Flowable<com.abrahamlay.gojekclone.domain.entities.DetailMovieModel>


}