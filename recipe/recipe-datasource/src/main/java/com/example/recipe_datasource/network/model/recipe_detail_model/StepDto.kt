package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.Step
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StepDto(
    @SerialName("equipment")
    val equipment: List<EquipmentDto>,
    @SerialName("ingredients")
    val ingredients: List<IngredientDto>,
    @SerialName("number")
    val number: Int,
    @SerialName("step")
    val step: String,
    @SerialName("length")
    val length: LengthDto?=null,
)

fun convertStepDtoToStep(stepDto: StepDto): Step {
    return Step(
        equipment = stepDto.equipment.map { convertEquipmentDtoToEquipment(it) },
        ingredients = stepDto.ingredients.map { convertIngredientDtoToIngredient(it) },
        number = stepDto.number,
        step = stepDto.step,
        length = stepDto.length?.toLength()
    )
}