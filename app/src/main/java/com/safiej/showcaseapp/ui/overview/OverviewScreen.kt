package com.safiej.showcaseapp.ui.overview

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.safiej.showcaseapp.R
import com.safiej.showcaseapp.domain.CompanyInfo
import com.safiej.showcaseapp.ui.OverviewScreenViewModel

@Composable
fun OverviewScreen(
    overviewScreenViewModel: OverviewScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val companyInfo by overviewScreenViewModel.companyInfo.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        companyInfo?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp), contentAlignment = Alignment.Center
            ) {
                CompanyTitle(it.name, it.founded, it.founder)
            }
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(createInfoGridItems(it)) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp), contentAlignment = Alignment.Center
                    ) {
                        OverviewItem(label = it.label, value = it.value)
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OverviewButton(imgRes = R.drawable.baseline_rocket_24, label = "Launchpads") {
                        overviewScreenViewModel.onLaunchpadsClicked(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun CompanyTitle(text: String, year: Int, founder: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = text, style = TextStyle.Default.copy(color = Color.White, fontSize = 32.sp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Est. $year by $founder",
            style = TextStyle.Default.copy(color = Color.White, fontSize = 14.sp)
        )
    }
}

@Composable
fun OverviewItem(label: String, value: String) {
    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = TextStyle.Default.copy(color = Color.White, fontSize = 20.sp),
            textAlign = TextAlign.Center
        )
        Divider(color = Color.White, modifier = Modifier.padding(16.dp, 4.dp))
        Text(text = label, style = TextStyle.Default.copy(color = Color.White, fontSize = 10.sp))
    }
}

@Composable
fun OverviewButton(@DrawableRes imgRes: Int, label: String, onClick: () -> Unit) {
    Box(modifier = Modifier
        .background(Color(1f, 1f, 1f, 0.1f), shape = RoundedCornerShape(4.dp))
        .clickable { onClick() }
        .padding(32.dp, 8.dp))
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = imgRes), contentDescription = "")
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                style = TextStyle.Default.copy(color = Color.White, fontSize = 20.sp)
            )
        }
    }
}

class InfoGridItem(val label: String, val value: String)

private fun createInfoGridItems(companyInfo: CompanyInfo): List<InfoGridItem> {
    companyInfo.let {
        return listOf(
            InfoGridItem("Employees", it.employees.toString()),
            InfoGridItem("Vehicles", it.vehicles.toString()),
            InfoGridItem("Launch sites", it.launchSites.toString()),
            InfoGridItem("Test sites", it.testSites.toString()),
            InfoGridItem("CEO", it.ceo),
            InfoGridItem("CTO", it.cto),
            InfoGridItem("COO", it.coo),
            InfoGridItem("CTO of Propulsion", it.ctoPropulsion),
            InfoGridItem("Valuation", "${it.valuation}$"),
        )
    }
}