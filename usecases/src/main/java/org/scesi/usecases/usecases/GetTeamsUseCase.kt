package org.scesi.usecases

import org.scesi.domain.repositories.TeamRepository

class GetTeamsUseCase(
    private val teamRepository: TeamRepository
) {
    suspend operator fun invoke() =
        teamRepository.getAllTeams()
}