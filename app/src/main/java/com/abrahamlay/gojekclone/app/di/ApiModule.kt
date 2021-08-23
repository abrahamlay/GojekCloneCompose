package com.abrahamlay.gojekclone.app.di

import com.abrahamlay.gojekclone.data.remote.MovieApi
import com.abrahamlay.gojekclone.app.config.WebApiProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideWebApiProvider(): WebApiProvider = WebApiProvider

    @Singleton
    @Provides
    fun provideRetrofit(webApiProvider: WebApiProvider): Retrofit = webApiProvider.getRetrofit()

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(
        MovieApi::class.java
    )
}