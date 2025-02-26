package org.scesi.esqueleto.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.scesi.domain.models.teams.Team
import org.scesi.usecases.usecases.GetTeamsUseCase
import org.scesi.domain.models.shared.EsqueletoResult

@KoinViewModel
class HomeViewModel(
    private val getTeamsUseCase: GetTeamsUseCase
) : ViewModel() {

    private val _teams = MutableStateFlow<List<Team>>(emptyList())
    val teams: StateFlow<List<Team>> = _teams.asStateFlow()

    init {
        fetchTeams()
    }

    private fun fetchTeams() {
        viewModelScope.launch {
            when (val result = getTeamsUseCase()) {
                is EsqueletoResult.Success -> {
                    _teams.value = result.data
                }
                is EsqueletoResult.Error -> {
                }
            }
        }
    }
}
