package ru.zar1official.chargelevelchecker.ui.theme.screens.battery

import androidx.lifecycle.ViewModel
import ru.zar1official.chargelevelchecker.data.storage.ChargeStore

class BatteryViewModel(private val store: ChargeStore) : ViewModel() {
    val charge = store.charge
}