package com.safiej.showcaseapp.repository

import com.safiej.showcaseapp.api.SpaceXService
import com.safiej.showcaseapp.domain.CompanyInfo
import com.safiej.showcaseapp.domain.LaunchpadInfo
import com.safiej.showcaseapp.domain.toCompanyInfo
import com.safiej.showcaseapp.domain.toLaunchPadInfo
import javax.inject.Inject

class SpaceXDataRepository @Inject constructor(
    private val spaceXService: SpaceXService
) {

    suspend fun getCompanyInfo(): CompanyInfo? = spaceXService.getCompanyInfo()?.toCompanyInfo()

    suspend fun getLaunchpadsInfo(): List<LaunchpadInfo> = spaceXService.getLaunchpadsInfo().map {
        it.toLaunchPadInfo()
    }

}