package com.example.recipe_datasource.network.model.recipe_list_model

import com.example.recipe_list_domain.RecipeList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeListDto(
    @SerialName("id")
    val number: Int,
    @SerialName("offset")
    val offset: Int,
    @SerialName("results")
    val results: List<ResultDto>,
    @SerialName("totalResults")
    val totalResults: Int,
)

fun RecipeListDto.toRecipeList(): RecipeList {
    return RecipeList(
        number = number,
        offset = offset,
        results = results.map { convertResultDtoToResult(it) },
        totalResults = totalResults
    )
}