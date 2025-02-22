package org.scesi.domain.models.teams

data class Team(
    val id: String,
    val name: String,
    val stadium: String,
    val city: String,
    val founded: Int,
    val logo: String,
    val championships: Int
)