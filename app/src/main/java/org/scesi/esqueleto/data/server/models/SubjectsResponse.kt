package org.scesi.esqueleto.data.server.models

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleRemote(
    val day: String,
    val start: String,
    val end: String,
    val duration: Int,
    val room: String,
    val teacher: String,
    val isClass: Boolean
)
@Serializable
data class GroupRemote(
    val code: String,
    val schedule: List<ScheduleRemote>,
    val teacher: String
)
@Serializable
data class SubjectRemote(
    val code: Int,
    val name: String,
    val groups: List<GroupRemote>
)
@Serializable
data class LevelRemote(
    val code: String,
    val subjects: List<SubjectRemote>
)
@Serializable
data class CourseScheduleRemote(
    val levels: List<LevelRemote>
)