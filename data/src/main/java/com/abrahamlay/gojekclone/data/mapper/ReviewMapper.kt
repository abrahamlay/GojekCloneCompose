package com.abrahamlay.gojekclone.data.mapper

import com.abrahamlay.gojekclone.data.dtos.ReviewDto
import com.abrahamlay.gojekclone.domain.entities.ReviewModel


/**
 * Created by Abraham Lay on 14/06/20.
 */

class ReviewMapper : Mapper<ReviewDto?, List<com.abrahamlay.gojekclone.domain.entities.ReviewModel>?>() {
    override fun apply(from: ReviewDto?): List<com.abrahamlay.gojekclone.domain.entities.ReviewModel>? {
        return from?.results?.map { resultReview ->
            com.abrahamlay.gojekclone.domain.entities.ReviewModel(
                resultReview.author,
                resultReview.content,
                resultReview.id,
                resultReview.url
            )
        }
    }
}