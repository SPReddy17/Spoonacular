package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.ProductMatches
import com.example.recipe_detail_domain.WinePairing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WinePairingDto(
    @SerialName("pairedWines")
    val pairedWines: List<String>,
    @SerialName("pairingText")
    val pairingText: String,
    @SerialName("productMatches")
    val productMatches: List<ProductMatchesDto>
)

fun WinePairingDto.toWinePairing(): WinePairing{
    return WinePairing(
        pairedWines = pairedWines,
        pairingText = pairingText,
        productMatches = productMatches.map { convertProductMatchesDtoToProductMatches(it) }
    )
}