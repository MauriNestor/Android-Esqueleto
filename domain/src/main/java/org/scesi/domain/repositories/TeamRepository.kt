package org.scesi.domain.repositories

import org.scesi.domain.models.shared.EsqueletoError
import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.domain.models.teams.Team

interface TeamRepository {
    suspend fun getAllTeams(): EsqueletoResult<List<Team>, EsqueletoError>
}