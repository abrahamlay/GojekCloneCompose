package com.abrahamlay.gojekclone.domain.entities


data class ReviewsModel(
    val id: Int?,
    val page: Int?,
    val results: List<com.abrahamlay.gojekclone.domain.entities.ReviewModel>?,
    val totalPages: Int?,
    val totalResults: Int?
)