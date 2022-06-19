package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.Equipment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentDto(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("localizedName")
    val localizedName: String,
    @SerialName("name")
    val name: String
)

fun convertEquipmentDtoToEquipment(equipmentDto: EquipmentDto): Equipment{
    return Equipment(
        id = equipmentDto.id,
        image = equipmentDto.image,
        localizedName = equipmentDto.localizedName,
        name = equipmentDto.name
    )
}
