package com.example.recipe_interactors

import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.core.UIComponent
import com.example.recipe_datasource.network.RecipeListService
import com.example.recipe_detail_domain.RecipeDetail
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipeDetail(
    private val service: RecipeListService
) {
    fun execute(id: Int, ): Flow<DataState<RecipeDetail>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            delay(2000)
            val recipeDetail: RecipeDetail = try {
                service.getRecipeDetail(id)
            } catch (e: Exception) {
                emit(
                    DataState.Response<RecipeDetail>(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Data Error",
                            description = e.message ?: "Uknown Error"
                        )
                    )
                )
                RecipeDetail(
                    null,
                    null,
                    false,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,null,
                    null,
                    null,null,null,null,null,null,null,null,null,null,null,null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
                )
            }
            // do caching in the future...
            emit(DataState.Data(recipeDetail))
        } catch (e: Exception) {
            emit(
                DataState.Response<RecipeDetail>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown Error"
                    )
                )
            )
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }

    }
}