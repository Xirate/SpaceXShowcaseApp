package com.safiej.showcaseapp.api

import com.safiej.showcaseapp.model.CompanyInfoResponse
import com.safiej.showcaseapp.model.LaunchpadResponse
import retrofit2.Response
import retrofit2.http.GET

interface SpaceXApi {

    @GET("company")
    suspend fun getCompanyInfo(): Response<CompanyInfoResponse>

    @GET("launchpads")
    suspend fun getLaunchpadsInfo(): Response<List<LaunchpadResponse>>

}