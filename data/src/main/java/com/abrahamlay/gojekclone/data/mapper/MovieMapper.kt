package com.abrahamlay.gojekclone.data.mapper

import com.abrahamlay.gojekclone.data.dtos.MovieDto
import com.abrahamlay.gojekclone.domain.entities.MovieModel

/**
 * Created by Abraham Lay on 14/06/20.
 */

class MovieMapper : Mapper<MovieDto?, List<com.abrahamlay.gojekclone.domain.entities.MovieModel>?>() {
    override fun apply(from: MovieDto?): List<com.abrahamlay.gojekclone.domain.entities.MovieModel>? {
        return from?.results?.map { movie ->
            com.abrahamlay.gojekclone.domain.entities.MovieModel(
                movie.voteCount,
                movie.id,
                movie.video,
                movie.voteAverage,
                movie.originalTitle,
                movie.popularity,
                movie.posterPath,
                movie.originalLanguage,
                movie.originalTitle,
                movie.genreIds,
                movie.backdropPath,
                movie.adult,
                movie.overview,
                movie.releaseDate

            )
        }
    }
}