package com.example.ui_recipe_list.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.DataState
import com.example.core.Logger
import com.example.core.UIComponent
import com.example.recipe_interactors.GetRecipeList
import com.example.recipe_list_domain.RecipeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    private val recipeList: GetRecipeList,
    private val savedStateHandle: SavedStateHandle,
    @Named("recipeListLogger") private val logger: Logger
) : ViewModel() {

    val state: MutableState<RecipeListState> = mutableStateOf(RecipeListState())

    init {
        onTriggerEvent(RecipeListEvents.GetRecipeList)
    }

     fun onTriggerEvent(event: RecipeListEvents) {
        when (event) {
            is RecipeListEvents.GetRecipeList -> {
                // default UI will be showing burger list
                getRecipeList("burger")
            }
            is RecipeListEvents.FilteredRecipe -> {
                filterRecipe()
            }
            is RecipeListEvents.UpdateRecipeName -> {
                updateRecipeName(event.recipeName)
            }
        }
    }

    private fun updateRecipeName(recipeName: String) {
        state.value = state.value.copy(recipeName = recipeName)
    }

    private fun filterRecipe() {
        getRecipeList(state.value.recipeName?:"")
    }

    private fun getRecipeList(query: String) {
        recipeList.execute(query).onEach { dataState ->
            when (dataState) {
                is DataState.Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is DataState.Data -> {
                    //change the recipe list
                    state.value = state.value.copy(
                        recipeList = dataState.data ?: RecipeList(
                            null,
                            null,
                            null,
                            null
                        )
                    )
                }
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
            }
        }.launchIn(viewModelScope)
    }
}