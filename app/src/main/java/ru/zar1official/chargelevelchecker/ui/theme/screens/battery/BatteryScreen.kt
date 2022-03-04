package ru.zar1official.chargelevelchecker.ui.theme.battery

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel
import ru.zar1official.chargelevelchecker.R
import ru.zar1official.chargelevelchecker.ui.theme.screens.battery.BatteryViewModel
import ru.zar1official.chargelevelchecker.ui.theme.screens.components.ScreenTopAppBar

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BatteryScreen() {
    val viewModel: BatteryViewModel = getViewModel()
    val chargeLevel = viewModel.charge.observeAsState(0)
    val chargeVisible = viewModel.textVisibility.observeAsState(true)

    Scaffold(topBar = {
        ScreenTopAppBar(titleResource = R.string.home_title)
    }) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (chargeLevel.value != 0) {
                Column {
                    Battery(chargeLevel = chargeLevel.value, modifier = Modifier.clickable {
                        viewModel.onShowChargeText()
                    })
                    Spacer(modifier = Modifier.height(30.dp))
                    AnimatedVisibility(visible = chargeVisible.value) {
                        Box(modifier = Modifier.width(80.dp), contentAlignment = Alignment.Center) {
                            Text(
                                text = chargeLevel.value.toString() + "%",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
            } else {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun Battery(
    modifier: Modifier = Modifier,
    width: Dp = 80.dp,
    height: Dp = 150.dp,
    chargeLevel: Int
) {
    val topBoxWidth = (width / 2.dp).dp
    val topBoxHeight = height / 8
    Box(
        modifier = modifier
            .padding(start = (width / 2 - topBoxHeight))
            .size(width = topBoxWidth, height = height / 10)
            .background(color = Color.DarkGray)
    )
    Card(
        shape = RoundedCornerShape(10.dp), modifier = modifier
            .width(width = width)
            .height(height = height),
        elevation = 10.dp
    ) {
        Column {
            val bottomHeight = (chargeLevel * height.value / 100).dp
            val topHeight = height - bottomHeight
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(topHeight)
                    .background(color = Color.Gray)
            )
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(bottomHeight)
                    .background(color = Color.Green)
            )
        }
    }
}