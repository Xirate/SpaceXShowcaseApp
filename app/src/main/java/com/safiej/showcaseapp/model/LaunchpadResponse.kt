package com.safiej.showcaseapp.model


data class LaunchpadResponse(
    val images: ImageInfo,
    val name: String,
    val full_name: String,
    val locality: String,
    val region: String,
    val latitude: Double,
    val longitude: Double,
    val launch_attempts: Int,
    val launch_successes: Int,
    val rockets: List<String>,
    val timezone: String,
    val launches: List<String>,
    val status: String,
    val details: String,
    val id: String
)

data class ImageInfo(
    val large: List<String>
)