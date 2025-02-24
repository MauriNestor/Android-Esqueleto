package org.scesi.esqueleto.data.server.models

import kotlinx.serialization.Serializable

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