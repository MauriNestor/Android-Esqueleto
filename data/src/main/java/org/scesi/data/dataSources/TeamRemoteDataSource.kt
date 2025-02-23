package org.scesi.data.dataSources

import org.scesi.domain.models.shared.EsqueletoError
import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.domain.models.teams.Team

interface TeamRemoteDataSource {
    suspend fun getTeams(): EsqueletoResult<List<Team>, EsqueletoError>
}