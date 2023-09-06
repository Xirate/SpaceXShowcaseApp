package com.safiej.showcaseapp.domain

import com.safiej.showcaseapp.model.LaunchpadResponse

data class LaunchpadInfo (
    val name: String,
    val fullName: String,
    val region: String,
    val latitude: Double,
    val longitude: Double,
    val attempts: Int,
    val successes: Int,
    val status: String,
    val details: String,
    val imageUrl: String
)

fun LaunchpadResponse.toLaunchPadInfo() = LaunchpadInfo(
    name = name,
    fullName = full_name,
    region = region,
    latitude = latitude,
    longitude = longitude,
    attempts = launch_attempts,
    successes = launch_successes,
    status = status,
    details = details,
    imageUrl = images.large[0]
)