package org.scesi.usecases.usecases

import org.koin.core.annotation.Factory
import org.scesi.domain.repositories.TeamRepository

@Factory
class GetTeamsUseCase(
    private val teamRepository: TeamRepository
) {
    suspend operator fun invoke() =
        teamRepository.getAllTeams()
}