package org.scesi.esqueleto.data.server.models

import kotlinx.serialization.Serializable

@Serializable
data class TeamsResponse(
    val teams: List<TeamRemote> = emptyList()
)
@Serializable
class TeamRemote (
    val id: String,
    val name: String,
    val stadium: String,
    val city: String,
    val founded: Int,
    val logo: String,
    val championships: Int
    )