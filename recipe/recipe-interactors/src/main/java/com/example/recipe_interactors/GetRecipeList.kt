package com.example.recipe_interactors

import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.core.UIComponent
import com.example.recipe_datasource.network.RecipeListService
import com.example.recipe_list_domain.RecipeList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipeList(
    private val service: RecipeListService
) {
    fun execute(query: String): Flow<DataState<RecipeList>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            delay(1000)
            val recipeList: RecipeList = try {
                service.getRecipeList(query)
            }catch (e : Exception){
                emit(
                    DataState.Response<RecipeList>(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Data Error",
                            description = e.message ?: "Uknown Error"
                        )
                    )
                )
                RecipeList(null,
                null,
                null,
                null)
            }
            println("recipeList -> $recipeList")
            emit(DataState.Data(recipeList))
        } catch (e: Exception) {
            emit(
                DataState.Response<RecipeList>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown Error"
                    )
                )
            )
        }
        finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}