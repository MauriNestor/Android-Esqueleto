package org.scesi.domain.models.teams


data class Schedule(
    val day: String,
    val start: String,
    val end: String,
    val duration: Int,
    val room: String,
    val teacher: String,
    val isClass: Boolean
)

data class Group(
    val code: String,
    val schedule: List<Schedule>,
    val teacher: String
)

data class Subject(
    val code: Int,
    val name: String,
    val groups: List<Group>
)

data class Level(
    val code: String,
    val subjects: List<Subject>
)

data class CourseSchedule(
    val levels: List<Level>
)
