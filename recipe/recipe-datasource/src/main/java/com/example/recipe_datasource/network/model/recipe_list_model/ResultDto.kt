package com.example.recipe_datasource.network.model.recipe_list_model

import com.example.recipe_list_domain.Result
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultDto(
    @SerialName("calories")
    val calories: Int? = null,
    @SerialName("carbs")
    val carbs: String? = null,
    @SerialName("fat")
    val fat: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("imageType")
    val imageType: String? = null,
    @SerialName("protein")
    val protein: String? = null,
    @SerialName("title")
    val title: String? = null,
)

fun convertResultDtoToResult(resultDto: ResultDto): Result {
    return Result(
        calories = resultDto.calories,
        carbs = resultDto.carbs,
        fat = resultDto.fat,
        id = resultDto.id,
        image = resultDto.image,
        imageType = resultDto.imageType,
        protein = resultDto.protein,
        title = resultDto.title
    )
}