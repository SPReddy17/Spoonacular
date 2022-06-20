package com.example.recipe_detail_domain

data class WinePairing(
    val pairedWines: List<String>?,
    val pairingText: String?,
    val productMatches: List<ProductMatches>?
)