package org.scesi.esqueleto.data.server

import org.scesi.data.dataSources.TeamRemoteDataSource
import org.scesi.domain.models.teams.Team
import org.scesi.esqueleto.data.server.models.TeamRemote

class TeamFakeApiDataSource: TeamRemoteDataSource {
    override suspend fun getTeams() {
        TODO("Not yet implemented")
    }
}
private fun List<TeamRemote>.toDomainModel(): List<Team> = map { it.toDomainModel() }

private fun TeamRemote.toDomainModel(): Team = Team(
    id = this.id,
    name = this.name,
    stadium = this.stadium,
    city = this.city,
    founded = this.founded,
    logo = this.logo,
    championships = this.championships
)