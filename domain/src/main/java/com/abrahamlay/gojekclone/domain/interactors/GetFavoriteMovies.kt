package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.FlowableUseCase
import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.MovieModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 13/06/20.
 */
class GetFavoriteMovies constructor(
    private val repository: MovieRepository,
    postExecutionThread: com.abrahamlay.gojekclone.domain.PostExecutionThread
) {
//    : FlowableUseCase<List<MovieModel>?, Void?>(postExecutionThread) {
//    override fun build(params: Void?): Flowable<List<MovieModel>?> {
//        return repository.getFavoriteMovies()
//    }
}