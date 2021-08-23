package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 13/06/20.
 */
class DeleteFavoriteMovie constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : com.abrahamlay.gojekclone.domain.FlowableUseCase<Int, DeleteFavoriteMovie.Params>(
    postExecutionThread
) {
    override fun build(params: Params): Flowable<Int> {
        return Flowable.just(
            null
//            repository.deleteFavoriteMovie(params.movieModel)
        )
    }

    data class Params(val movieModel: com.abrahamlay.gojekclone.domain.entities.MovieModel)
}

