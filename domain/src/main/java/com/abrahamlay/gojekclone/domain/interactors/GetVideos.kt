package com.abrahamlay.gojekclone.domain.interactors

import com.abrahamlay.gojekclone.domain.FlowableUseCase
import com.abrahamlay.gojekclone.domain.PostExecutionThread
import com.abrahamlay.gojekclone.domain.entities.VideoModel
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 10/06/20.
 */

class GetVideos constructor(
    private val repository: MovieRepository,
    postExecutionThread: com.abrahamlay.gojekclone.domain.PostExecutionThread
) : com.abrahamlay.gojekclone.domain.FlowableUseCase<List<com.abrahamlay.gojekclone.domain.entities.VideoModel>, GetVideos.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<com.abrahamlay.gojekclone.domain.entities.VideoModel>> {
        return repository.getVideo(params.apiKey, params.movieId)
    }

    data class Params(val apiKey: String, val movieId: Int)
}