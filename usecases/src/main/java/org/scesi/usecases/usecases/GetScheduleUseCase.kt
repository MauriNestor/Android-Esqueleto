package org.scesi.usecases.usecases

import org.koin.core.annotation.Factory
import org.scesi.domain.repositories.ScheduleRepository

@Factory
class GetScheduleUseCase(
    private val scheduleRepository: ScheduleRepository
){
    suspend operator fun invoke() =
        scheduleRepository.getSchedule()
}