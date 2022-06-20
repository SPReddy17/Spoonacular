package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.AnalyzedInstruction
import com.example.recipe_detail_domain.Step
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnalyzedInstructionDto(
    @SerialName("name")
    val name: String?,
    @SerialName("steps")
    val steps: List<StepDto>?
)

fun convertAnalyzedInstructionDtoToAnalyzedInstruction(analyzedInstructionDto:AnalyzedInstructionDto): AnalyzedInstruction{
    return AnalyzedInstruction(
        name = analyzedInstructionDto.name,
        steps = analyzedInstructionDto.steps?.map { convertStepDtoToStep(it) }
    )
}