package org.scesi.data.repositories

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.TeamRemoteDataSource
import org.scesi.domain.models.shared.EsqueletoError
import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.domain.models.teams.Team
import org.scesi.domain.repositories.TeamRepository
import javax.inject.Inject

@Factory
class TeamRepositoryImpl @Inject constructor(
    private val teamRemoteDataSource: TeamRemoteDataSource
): TeamRepository
{
    override suspend fun getAllTeams(): EsqueletoResult<List<Team>, EsqueletoError> {
        return teamRemoteDataSource.getTeams()
    }

}