package org.scesi.domain.repositories

import org.scesi.domain.models.shared.EsqueletoError
import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.domain.models.teams.CourseSchedule

interface ScheduleRepository {
    suspend fun getSchedule(): EsqueletoResult<List<CourseSchedule>, EsqueletoError>
}