package com.safiej.showcaseapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.safiej.showcaseapp.domain.CompanyInfo
import com.safiej.showcaseapp.navigation.Screen
import com.safiej.showcaseapp.usecase.GetCompanyInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OverviewScreenViewModel @Inject constructor(
    private val useCases: OverviewScreenViewModelUseCases
) : ViewModel() {

    private val _companyInfo: MutableStateFlow<CompanyInfo?> = MutableStateFlow(null)
    val companyInfo: StateFlow<CompanyInfo?>
        get() = _companyInfo

    init {
        getCompanyInfo()
    }

    private fun getCompanyInfo() {
        viewModelScope.launch {
            try {
                val companyInfo = useCases.getCompanyInfoUseCase()
                _companyInfo.value = companyInfo
            } catch (_: Exception) {

            }
        }
    }

    fun onLaunchpadsClicked(navController: NavHostController) {
        navController.navigate(Screen.LaunchpadsScreen.route)
    }
}

class OverviewScreenViewModelUseCases @Inject constructor(
    val getCompanyInfoUseCase: GetCompanyInfoUseCase
)