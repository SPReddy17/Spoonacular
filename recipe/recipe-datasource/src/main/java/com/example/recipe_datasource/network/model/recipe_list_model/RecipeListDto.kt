package com.example.recipe_datasource.network.model.recipe_list_model

import com.example.recipe_list_domain.RecipeList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeListDto(
    @SerialName("results")
    val results: List<ResultDto> ? = null,
    @SerialName("offset")
    val offset: Int?=null,
    @SerialName("number")
    val number: Int?=null,
    @SerialName("totalResults")
    val totalResults: Int?=null,
)

fun RecipeListDto.toRecipeList(): RecipeList {
    return RecipeList(
        number = number,
        offset = offset,
        results = results?.map { convertResultDtoToResult(it) },
        totalResults = totalResults
    )
}