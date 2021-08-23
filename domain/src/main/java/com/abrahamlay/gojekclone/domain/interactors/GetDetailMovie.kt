package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.FlowableUseCase
import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.DetailMovieModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 10/06/20.
 */
class GetDetailMovie constructor(
    private val repository: MovieRepository,
    postExecutionThread: com.abrahamlay.gojekclone.domain.PostExecutionThread
) : com.abrahamlay.gojekclone.domain.FlowableUseCase<com.abrahamlay.gojekclone.domain.entities.DetailMovieModel, GetDetailMovie.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<com.abrahamlay.gojekclone.domain.entities.DetailMovieModel> {
        return repository.getMovieDetails(params.apiKey, params.movieId)
    }

    data class Params(val apiKey: String, val movieId: Int)
}