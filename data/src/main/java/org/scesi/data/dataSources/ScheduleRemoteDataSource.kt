package org.scesi.data.dataSources

import org.scesi.domain.models.shared.EsqueletoError
import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.domain.models.teams.CourseSchedule


interface ScheduleRemoteDataSource {
    suspend fun getSchedule(): EsqueletoResult<List<CourseSchedule>, EsqueletoError>
}