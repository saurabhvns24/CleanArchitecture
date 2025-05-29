package com.example.cleanarchitecturewithhilt.di

import com.example.cleanarchitecturewithhilt.core.util.Constants.BASE_URL
import com.example.cleanarchitecturewithhilt.data.api.CharacterApi
import com.example.cleanarchitecturewithhilt.data.repository.CharacterRepositoryImpl
import com.example.cleanarchitecturewithhilt.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi =
        retrofit.create(CharacterApi::class.java)

    @Provides
    fun provideCharacterRepository(api: CharacterApi): CharacterRepository =
        CharacterRepositoryImpl(api)

}