package org.scesi.esqueleto.data.server

import org.scesi.esqueleto.data.server.models.TeamsResponse
import retrofit2.http.GET

interface TeamService {
    @GET("not-yet")
    suspend fun getTeams(): TeamsResponse
}