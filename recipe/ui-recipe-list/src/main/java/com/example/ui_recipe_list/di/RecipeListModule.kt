package com.example.ui_recipe_list.di

import com.example.core.Logger
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
object RecipeListModule {

    @Provides
    @Singleton
    fun provideGetRecipeList(
        interactors: RecipeInteractors
    ): GetRecipeList {
        return interactors.getRecipeList
    }

    @Provides
    @Singleton
    @Named("recipeListLogger")
    fun provideLogger(): Logger {
        return Logger(
            tag = "RecipeList",
            isDebug = true
        )
    }
}