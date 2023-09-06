package com.safiej.showcaseapp.api

import com.safiej.showcaseapp.model.CompanyInfoResponse
import com.safiej.showcaseapp.model.LaunchpadResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpaceXService @Inject constructor(
    private val spaceXApi: SpaceXApi
) {

    suspend fun getCompanyInfo(): CompanyInfoResponse? {
        return withContext(Dispatchers.IO) {
            spaceXApi.getCompanyInfo().body()
        }
    }

    suspend fun getLaunchpadsInfo(): List<LaunchpadResponse> {
        return withContext(Dispatchers.IO) {
            spaceXApi.getLaunchpadsInfo().body() ?: emptyList()
        }
    }

}