package org.scesi.data.repositories

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.ScheduleRemoteDataSource
import org.scesi.domain.models.shared.EsqueletoError
import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.domain.models.teams.CourseSchedule
import org.scesi.domain.repositories.ScheduleRepository
import javax.inject.Inject

@Factory
class ScheduleRepositoryImpl @Inject constructor (
    private val scheduleRemoteDataSource: ScheduleRemoteDataSource
): ScheduleRepository
{
    override suspend fun getSchedule(): EsqueletoResult<List<CourseSchedule>, EsqueletoError> {
        return scheduleRemoteDataSource.getSchedule()
    }
}