package com.safiej.showcaseapp.domain

import com.safiej.showcaseapp.model.CompanyInfoResponse
import com.safiej.showcaseapp.model.HeadquartersResponse
import com.safiej.showcaseapp.model.LinksResponse

data class CompanyInfo (
    val name: String,
    val founder: String,
    val founded: Int,
    val employees: Int,
    val vehicles: Int,
    val launchSites: Int,
    val testSites: Int,
    val ceo: String,
    val cto: String,
    val coo: String,
    val ctoPropulsion: String,
    val valuation: Long,
    val summary: String,
    val headquartersInfo: HeadquartersInfo,
    val linksInfo: LinksInfo
    )

data class HeadquartersInfo (
    val address: String,
    val city: String,
    val state: String
    )

data class LinksInfo (
    val website: String,
    val flickr: String,
    val x: String,
    val elonX: String
    )

fun CompanyInfoResponse.toCompanyInfo() = CompanyInfo(
    name = name,
    founder = founder,
    founded = founded,
    employees = employees,
    vehicles = vehicles,
    launchSites = launch_sites,
    testSites = test_sites,
    ceo = ceo,
    cto = cto,
    coo = coo,
    ctoPropulsion = cto_propulsion,
    valuation = valuation,
    summary = summary,
    headquartersInfo = headquarters.toHeadquartersInfo(),
    linksInfo = links.toLinksInfo()
)

fun HeadquartersResponse.toHeadquartersInfo() = HeadquartersInfo(
    address, city, state
)

fun LinksResponse.toLinksInfo() = LinksInfo(
    website, flickr, twitter, elon_twitter
)
