package com.abrahamlay.gojekclone.app.di

import com.abrahamlay.gojekclone.data.mapper.DetailMovieMapper
import com.abrahamlay.gojekclone.data.mapper.MovieMapper
import com.abrahamlay.gojekclone.data.mapper.ReviewMapper
import com.abrahamlay.gojekclone.data.mapper.VideoMapper
import com.abrahamlay.gojekclone.data.remote.MovieApi
import com.abrahamlay.gojekclone.data.repositoriesimpl.MovieRepositoryImpl
import com.abrahamlay.gojekclone.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieApi: MovieApi): MovieRepository =
        MovieRepositoryImpl(
            movieApi, MovieMapper(), ReviewMapper(),
            VideoMapper(), DetailMovieMapper()
        )

//    @Singleton
//    @Provides
//    fun provideAppDatabase(context: Context): AppDatabase =
//        Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.APPLICATION_ID)
//            .build()
//
//    @Singleton
//    @Provides
//    fun provideMovieDao(appDatabase: AppDatabase) = appDatabase.movieDao()
}