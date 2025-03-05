package org.scesi.esqueleto.data.server

import org.scesi.esqueleto.data.server.models.CourseScheduleRemote
import org.scesi.esqueleto.data.server.models.TeamRemote
import retrofit2.http.GET

interface TeamService {
    @GET("366f9b08-7d72-4b9c-adb6-828c4aaddef6")
    suspend fun getTeams(): List<TeamRemote>

    @GET("FCyT/2025-01/411702.json")
    suspend fun getSchedule(): CourseScheduleRemote
}