package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.FlowableUseCase
import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.MovieModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 13/06/20.
 */
class InsertFavoriteMovie constructor(
    private val repository: MovieRepository,
    postExecutionThread: com.abrahamlay.gojekclone.domain.PostExecutionThread
) {
//    : FlowableUseCase<Long, InsertFavoriteMovie.Params>(postExecutionThread) {
//    override fun build(params: Params): Flowable<Long> {
//        return Flowable.just(repository.insertFavoriteMovie(params.movieModel))
//    }
//
//    data class Params(val movieModel: MovieModel)
}

