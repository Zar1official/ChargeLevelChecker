package ru.zar1official.chargelevelchecker.data.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import ru.zar1official.chargelevelchecker.data.storage.ChargeStore

class BatteryReceiver(private val storage: ChargeStore) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0) ?: 0
        storage.changeCharge(level)
    }
}