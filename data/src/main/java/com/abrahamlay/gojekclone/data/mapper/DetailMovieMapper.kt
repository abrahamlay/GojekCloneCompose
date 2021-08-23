package com.abrahamlay.gojekclone.data.mapper

import com.abrahamlay.gojekclone.data.dtos.DetailMovieDto
import com.abrahamlay.gojekclone.domain.entities.DetailMovieModel

/**
 * Created by Abraham Lay on 14/06/20.
 */

class DetailMovieMapper : Mapper<DetailMovieDto?, com.abrahamlay.gojekclone.domain.entities.DetailMovieModel>() {
    override fun apply(from: DetailMovieDto?): com.abrahamlay.gojekclone.domain.entities.DetailMovieModel {
        return com.abrahamlay.gojekclone.domain.entities.DetailMovieModel(
            from?.adult,
            from?.backdropPath,
            from?.belongsToCollection,
            from?.budget,
            from?.genres?.map { genre ->
                com.abrahamlay.gojekclone.domain.entities.DetailMovieModel.Genre(
                    genre?.id,
                    genre?.name
                )
            },
            from?.homepage,
            from?.id,
            from?.imdbId,
            from?.originalLanguage,
            from?.originalTitle,
            from?.overview,
            from?.popularity,
            from?.posterPath,
            from?.productionCompanies?.map { company ->
                com.abrahamlay.gojekclone.domain.entities.DetailMovieModel.ProductionCompany(
                    company?.id,
                    company?.logoPath,
                    company?.name,
                    company?.originCountry
                )
            },
            from?.productionCountries?.map { country ->
                com.abrahamlay.gojekclone.domain.entities.DetailMovieModel.ProductionCountry(
                    country?.iso31661,
                    country?.name
                )
            },
            from?.releaseDate,
            from?.revenue,
            from?.runtime,
            from?.spokenLanguages?.map { language ->
                com.abrahamlay.gojekclone.domain.entities.DetailMovieModel.SpokenLanguage(
                    language?.iso6391,
                    language?.name
                )
            },
            from?.status,
            from?.tagline,
            from?.title,
            from?.video,
            from?.voteAverage,
            from?.voteCount
        )
    }
}
