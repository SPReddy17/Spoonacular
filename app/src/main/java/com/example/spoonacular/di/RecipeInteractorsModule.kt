package com.example.spoonacular.di

import com.example.recipe_interactors.RecipeInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeInteractorsModule {

    /* add when implementing database
    @Provides
    @Singleton
    fun provideAndroidDriver(app: Application): SqlDriver{
        return AndroidSqliteDriver(
        )
    }
    *
     */

    @Provides
    @Singleton
    fun provideRecipeInteractors(
    ): RecipeInteractors {
        return RecipeInteractors.build()
    }
}