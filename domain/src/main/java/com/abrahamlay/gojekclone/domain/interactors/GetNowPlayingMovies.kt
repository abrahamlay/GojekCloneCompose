package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.FlowableUseCase
import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.MovieModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable


/**
 * Created by Abraham Lay on 2019-09-29.
 */
class GetNowPlayingMovies constructor(
    private val repository: MovieRepository,
    postExecutionThread: com.abrahamlay.gojekclone.domain.PostExecutionThread
) : com.abrahamlay.gojekclone.domain.FlowableUseCase<List<com.abrahamlay.gojekclone.domain.entities.MovieModel>?, GetNowPlayingMovies.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<com.abrahamlay.gojekclone.domain.entities.MovieModel>?> =
        repository.getNowPlayingMovies(params.apiKey)

    data class Params(val apiKey: String)
}