package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.FlowableUseCase
import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.ReviewModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 10/06/20.
 */
class GetReviews constructor(
    private val repository: MovieRepository,
    postExecutionThread: com.abrahamlay.gojekclone.domain.PostExecutionThread
) : com.abrahamlay.gojekclone.domain.FlowableUseCase<List<com.abrahamlay.gojekclone.domain.entities.ReviewModel>, GetReviews.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<com.abrahamlay.gojekclone.domain.entities.ReviewModel>> {
        return repository.getReviews(params.apiKey, params.movieId)
    }

    data class Params(val apiKey: String, val movieId: Int)
}