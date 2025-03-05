package org.scesi.esqueleto.data.server

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.ScheduleRemoteDataSource
import org.scesi.domain.models.teams.CourseSchedule
import org.scesi.esqueleto.data.server.models.CourseScheduleRemote
import org.scesi.esqueleto.data.tryCall
import org.scesi.domain.models.teams.Group as DomainGroup
import org.scesi.domain.models.teams.Level as DomainLevel
import org.scesi.domain.models.teams.Schedule as DomainSchedule
import org.scesi.domain.models.teams.Subject as DomainSubject

@Factory
class ScheduleFakeApiDataSource: ScheduleRemoteDataSource {
    override suspend fun getSchedule() = tryCall {
        listOf(RemoteConnection.service.getSchedule().toDomainModel())

    }
}
private fun List<CourseScheduleRemote>.toDomainModel(): List<CourseSchedule> = map { it.toDomainModel() }


private fun CourseScheduleRemote.toDomainModel(): CourseSchedule = CourseSchedule(
    levels = this.levels.map { level ->
        DomainLevel(
            code = level.code,
            subjects = level.subjects.map { subject ->
                DomainSubject(
                    code = subject.code,
                    name = subject.name,
                    groups = subject.groups.map { group ->
                        DomainGroup(
                            code = group.code,
                            teacher = group.teacher,
                            schedule = group.schedule.map { schedule ->
                                DomainSchedule(
                                    day = schedule.day,
                                    start = schedule.start,
                                    end = schedule.end,
                                    duration = schedule.duration,
                                    room = schedule.room,
                                    teacher = schedule.teacher,
                                    isClass = schedule.isClass
                                )
                            }
                        )
                    }
                )
            }
        )
    }
)
