package ru.zar1official.chargelevelchecker.ui.theme.battery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel
import ru.zar1official.chargelevelchecker.R
import ru.zar1official.chargelevelchecker.ui.theme.screens.battery.BatteryViewModel
import ru.zar1official.chargelevelchecker.ui.theme.screens.components.ScreenTopAppBar

@Composable
fun BatteryScreen() {
    val viewModel: BatteryViewModel = getViewModel()
    val chargeLevel = viewModel.charge.observeAsState(0)
    Scaffold(topBar = {
        ScreenTopAppBar(titleResource = R.string.home_title)
    }) {

    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (chargeLevel.value != 0) {
            Column {
                Battery(width = 80, height = 400, chargeLevel = chargeLevel.value)
                Spacer(modifier = Modifier.height(30.dp))
                Box(modifier = Modifier.width(80.dp), contentAlignment = Alignment.Center) {
                    Text(
                        text = chargeLevel.value.toString() + "%",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        } else {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun Battery(
    width: Int,
    height: Int,
    chargeLevel: Int
) {
    Card(
        shape = RoundedCornerShape(10.dp), modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp),
        elevation = 10.dp
    ) {
        Column {
            val bottomHeight = (chargeLevel * height / 100)
            val topHeight = height - bottomHeight
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(topHeight.dp)
                    .background(color = Color.Gray)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(bottomHeight.dp)
                    .background(color = Color.Green)
            )
        }
    }
}