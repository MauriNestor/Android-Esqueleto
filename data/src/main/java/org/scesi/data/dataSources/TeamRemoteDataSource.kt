package org.scesi.data.dataSources

interface TeamRemoteDataSource {
    suspend fun getTeams()
}