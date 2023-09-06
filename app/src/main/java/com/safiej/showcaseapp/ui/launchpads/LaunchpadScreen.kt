package com.safiej.showcaseapp.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.safiej.showcaseapp.R
import com.safiej.showcaseapp.domain.LaunchpadInfo
import com.safiej.showcaseapp.ui.launchpads.LaunchpadScreenViewModel

@Composable
fun LaunchpadScreen(launchpadScreenViewModel: LaunchpadScreenViewModel = hiltViewModel()) {
    val launchpads by launchpadScreenViewModel.launchpads.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(horizontal = 12.dp)
    ) {
        item {
            LaunchpadsHeader()
        }
        items(launchpads) {
            LaunchpadItem(launchpad = it)
        }
    }
}

@Composable
fun LaunchpadsHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp), contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(id = R.drawable.baseline_rocket_24), contentDescription = "")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Launchpads",
                    style = TextStyle.Default.copy(color = Color.White, fontSize = 24.sp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier.padding(horizontal = 32.dp),
                color = Color(1f, 1f, 1f, 0.4f)
            )
        }
    }
}

@Composable
fun LaunchpadItem(launchpad: LaunchpadInfo) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(12.dp))
        Text(launchpad.name, style = TextStyle.Default.copy(color = Color.White, fontSize = 18.sp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(launchpad.fullName, style = TextStyle.Default.copy(color = Color.White, fontSize = 12.sp))
        Spacer(modifier = Modifier.height(4.dp))
        Text("${launchpad.latitude}; ${launchpad.longitude}, ${launchpad.region}", style = TextStyle.Default.copy(color = Color.White, fontSize = 12.sp))
        Spacer(modifier = Modifier.height(4.dp))
        Text("Attempted ${launchpad.attempts} launches, ${launchpad.successes} succeeded.", style = TextStyle.Default.copy(color = Color.White, fontSize = 12.sp))
        Spacer(modifier = Modifier.height(4.dp))
        Text("Current status: ${launchpad.status}", style = TextStyle.Default.copy(color = Color.White, fontSize = 12.sp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(launchpad.details, style = TextStyle.Default.copy(color = Color.White, fontSize = 12.sp))
        Spacer(modifier = Modifier.height(12.dp))
        Divider(modifier = Modifier.padding(horizontal = 64.dp), color = Color(1f, 1f, 1f, 0.2f))
    }
}