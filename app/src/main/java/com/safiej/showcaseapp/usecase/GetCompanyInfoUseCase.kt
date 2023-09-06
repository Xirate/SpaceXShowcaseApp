package com.safiej.showcaseapp.usecase

import com.safiej.showcaseapp.domain.CompanyInfo
import com.safiej.showcaseapp.repository.SpaceXDataRepository
import javax.inject.Inject

class GetCompanyInfoUseCase @Inject constructor(
    private val spaceXDataRepository: SpaceXDataRepository
) {

    suspend operator fun invoke(): CompanyInfo? {
        return spaceXDataRepository.getCompanyInfo()
    }
}