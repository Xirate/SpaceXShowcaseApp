package com.safiej.showcaseapp.usecase

import com.safiej.showcaseapp.domain.CompanyInfo
import com.safiej.showcaseapp.domain.LaunchpadInfo
import com.safiej.showcaseapp.repository.SpaceXDataRepository
import javax.inject.Inject

class GetLaunchpadsInfoUseCase@Inject constructor(
    private val spaceXDataRepository: SpaceXDataRepository
) {

    suspend operator fun invoke(): List<LaunchpadInfo> {
        return spaceXDataRepository.getLaunchpadsInfo()
    }
}