package com.safiej.showcaseapp.model

data class CompanyInfoResponse(
    val headquarters: HeadquartersResponse,
    val links: LinksResponse,
    val name: String,
    val founder: String,
    val founded: Int,
    val employees: Int,
    val vehicles: Int,
    val launch_sites: Int,
    val test_sites: Int,
    val ceo: String,
    val cto: String,
    val coo: String,
    val cto_propulsion: String,
    val valuation: Long,
    val summary: String,
    val id: String
)

data class HeadquartersResponse(
    val address: String,
    val city: String,
    val state: String
)

data class LinksResponse(
    val website: String,
    val flickr: String,
    val twitter: String,
    val elon_twitter: String
)

