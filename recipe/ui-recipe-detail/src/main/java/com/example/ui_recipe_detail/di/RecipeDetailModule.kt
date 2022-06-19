package com.example.ui_recipe_detail.di

import com.example.core.Logger
import com.example.recipe_interactors.GetRecipeDetail
import com.example.recipe_interactors.GetRecipeList
import com.example.recipe_interactors.RecipeInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeDetailModule {

    @Provides
    @Singleton
    fun provideGetRecipeList(
        interactors: RecipeInteractors
    ): GetRecipeDetail {
        return interactors.getRecipeDetail
    }

    @Provides
    @Singleton
    @Named("recipeDetailLogger")
    fun provideLogger(): Logger {
        return Logger(
            tag = "RecipeDetail",
            isDebug = true
        )
    }
}