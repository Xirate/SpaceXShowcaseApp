package com.safiej.showcaseapp.model

data class RocketResponse(
    val height: Measurement,
    val diameter: Measurement,
    val mass: Weight,
    val first_stage: StageDetails,
    val second_stage: StageDetails,
    val engines: EngineDetails,
    val landing_legs: LandingLegs,
    val payload_weights: List<PayloadWeight>,
    val flickr_images: List<String>,
    val name: String,
    val type: String,
    val active: Boolean,
    val stages: Int,
    val boosters: Int,
    val cost_per_launch: Long,
    val success_rate_pct: Int,
    val first_flight: String,
    val country: String,
    val company: String,
    val wikipedia: String,
    val description: String,
    val id: String
)

data class Measurement(
    val meters: Double,
    val feet: Double
)

data class Weight(
    val kg: Int,
    val lb: Int
)

data class StageDetails(
    val thrust_sea_level: Thrust,
    val thrust_vacuum: Thrust,
    val reusable: Boolean,
    val engines: Int,
    val fuel_amount_tons: Double,
    val burn_time_sec: Int?,
    val thrust: Thrust?,
    val payloads: Payloads,
    val option_1: String
)

data class Thrust(
    val kN: Double,
    val lbf: Double
)

data class Payloads(
    val composite_fairing: Measurement?
)

data class EngineDetails(
    val isp: ISP,
    val thrust_sea_level: Thrust,
    val thrust_vacuum: Thrust,
    val number: Int,
    val type: String,
    val version: String,
    val layout: String?,
    val engine_loss_max: Int?,
    val propellant_1: String,
    val propellant_2: String,
    val thrust_to_weight: Double
)

data class ISP(
    val sea_level: Int,
    val vacuum: Int
)

data class LandingLegs(
    val number: Int,
    val material: String?
)

data class PayloadWeight(
    val id: String,
    val name: String,
    val kg: Int,
    val lb: Int
)