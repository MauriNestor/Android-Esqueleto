package org.scesi.esqueleto.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.domain.models.teams.CourseSchedule
import org.scesi.usecases.usecases.GetScheduleUseCase

@KoinViewModel
class HomeViewModel(
    private val getScheduleUseCase: GetScheduleUseCase
) : ViewModel() {

    private val _schedules = MutableStateFlow<List<CourseSchedule>>(emptyList())
    val schedules: StateFlow<List<CourseSchedule>> = _schedules.asStateFlow()

    init {
        fetchSchedules()
    }

    private fun fetchSchedules() {
        viewModelScope.launch {
            when (val result = getScheduleUseCase()) {
                is EsqueletoResult.Success -> {
                    _schedules.value = result.data
                }
                is EsqueletoResult.Error -> {
                }
            }
        }
    }
}