package ru.zar1official.chargelevelchecker

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.android.ext.android.inject
import ru.zar1official.chargelevelchecker.data.receiver.BatteryReceiver
import ru.zar1official.chargelevelchecker.ui.theme.ChargeLevelCheckerTheme
import ru.zar1official.chargelevelchecker.ui.theme.screens.main.MainScreen

class MainActivity : ComponentActivity() {
    private val receiver: BatteryReceiver by inject()
    override fun onResume() {
        super.onResume()
        registerReceiver(
            receiver,
            IntentFilter().apply { addAction(Intent.ACTION_BATTERY_CHANGED) })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChargeLevelCheckerTheme {
                MainScreen()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}