package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.Ingredient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class IngredientDto(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("localizedName")
    val localizedName: String,
    @SerialName("name")
    val name: String
)

fun convertIngredientDtoToIngredient(ingredientDto: IngredientDto): Ingredient {
    return Ingredient(
        id = ingredientDto.id,
        image = ingredientDto.image,
        localizedName = ingredientDto.localizedName,
        name = ingredientDto.name
    )
}