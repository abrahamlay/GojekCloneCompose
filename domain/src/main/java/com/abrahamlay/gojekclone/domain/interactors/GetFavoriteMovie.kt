package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.FlowableUseCase
import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.MovieModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 13/06/20.
 */
class GetFavoriteMovie constructor(
    private val repository: MovieRepository,
    postExecutionThread: com.abrahamlay.gojekclone.domain.PostExecutionThread
) {
//    : FlowableUseCase<MovieModel?, GetFavoriteMovie.Params>(postExecutionThread) {
//    override fun build(params: Params): Flowable<MovieModel?> {
//        return repository.getFavoriteMovie(params.movieId)
//    }

    data class Params(val movieId: Int)
}
