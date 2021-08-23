package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.MovieModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-09-29.
 */


class GetPopularMovies constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : com.abrahamlay.gojekclone.domain.FlowableUseCase<List<MovieModel>?, GetPopularMovies.Params>(
    postExecutionThread
) {
    override fun build(params: Params): Flowable<List<MovieModel>?> =
        repository.getPopularMovies(params.apiKey)

    data class Params(val apiKey: String)
}