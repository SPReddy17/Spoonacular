package com.example.recipe_datasource.network.model.recipe_list_model

import com.example.recipe_list_domain.Result
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultDto(
    @SerialName("calories")
    val calories: Int,
    @SerialName("carbs")
    val carbs: String,
    @SerialName("fat")
    val fat: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("imageType")
    val imageType: String,
    @SerialName("protein")
    val protein: String,
    @SerialName("title")
    val title: String,
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