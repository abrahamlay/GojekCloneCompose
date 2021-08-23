package com.abrahamlay.gojekclone.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abrahamlay.gojekclone.domain.entities.MovieModel
import com.abrahamlay.gojekclone.domain.interactors.GetPopularMovies
import com.abrahamlay.gojekclone.domain.subscriber.DefaultSubscriber
import com.abrahamlay.gojekclone.domain.subscriber.ResultState
import com.abrahamlay.gojekclone.app.config.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMovies
) : ViewModel() {
    val movies: MutableState<ResultState<List<MovieModel>?>> =
        mutableStateOf(
            ResultState.Loading(
                arrayListOf()
            )
        )

    fun fetchMovie() {
        getPopularMovies.execute(
            object : DefaultSubscriber<List<MovieModel>?>() {
                override fun onError(error: ResultState<List<MovieModel>?>) {
                    movies.value = error
                }

                override fun onSuccess(data: ResultState<List<MovieModel>?>) {
                    movies.value = data
                }
            }, GetPopularMovies.Params(Constants.API_KEY)
        )
    }

    override fun onCleared() {
        super.onCleared()
        getPopularMovies.dispose()
    }
}