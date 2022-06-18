package com.example.recipe_interactors

import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.core.UIComponent
import com.example.recipe_datasource.network.RecipeListService
import com.example.recipe_list_domain.RecipeList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipeList(
    private val service: RecipeListService
) {
    fun execute(query: String): Flow<DataState<List<RecipeList>>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            val recipeList: List<RecipeList> = try {
                service.getRecipeList(query)
            }catch (e : Exception){
                emit(
                    DataState.Response(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Data Error",
                            description = e.message ?: "Uknown Error"
                        )
                    )
                )
                listOf()
            }
            emit(DataState.Data(recipeList))
        } catch (e: Exception) {
            emit(
                DataState.Response(
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