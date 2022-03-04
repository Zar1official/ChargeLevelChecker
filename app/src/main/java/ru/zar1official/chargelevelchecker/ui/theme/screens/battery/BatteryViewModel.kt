package ru.zar1official.chargelevelchecker.ui.theme.screens.battery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.zar1official.chargelevelchecker.data.storage.ChargeStore

class BatteryViewModel(store: ChargeStore) : ViewModel() {
    val charge = store.charge

    private val _textVisibility = MutableLiveData<Boolean>().apply {
        value = true
    }
    val textVisibility: LiveData<Boolean> = _textVisibility

    fun onShowChargeText() {
        _textVisibility.value = !_textVisibility.value!!
    }
}