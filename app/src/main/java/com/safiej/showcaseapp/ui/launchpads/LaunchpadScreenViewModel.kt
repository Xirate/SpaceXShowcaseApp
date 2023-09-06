package com.safiej.showcaseapp.ui.launchpads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safiej.showcaseapp.domain.LaunchpadInfo
import com.safiej.showcaseapp.usecase.GetLaunchpadsInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchpadScreenViewModel @Inject constructor(
    private val useCases: LaunchpadScreenViewModelUseCases
): ViewModel() {

    private val _launchpads = MutableStateFlow(emptyList<LaunchpadInfo>())
    val launchpads: StateFlow<List<LaunchpadInfo>>
        get() = _launchpads

    init {
        getLaunchpadsInfo()
    }

    private fun getLaunchpadsInfo() {
        viewModelScope.launch {
            try {
                val launchpads = useCases.getLaunchpadsInfoUseCase()
                _launchpads.value = launchpads
            } catch (_: Exception) {

            }
        }
    }
}

class LaunchpadScreenViewModelUseCases @Inject constructor(
    val getLaunchpadsInfoUseCase: GetLaunchpadsInfoUseCase
)