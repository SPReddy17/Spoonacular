package com.example.recipe_detail_domain

data class WinePairing(
    val pairedWines: List<Any>,
    val pairingText: String,
    val productMatches: List<ProductMatches>
)