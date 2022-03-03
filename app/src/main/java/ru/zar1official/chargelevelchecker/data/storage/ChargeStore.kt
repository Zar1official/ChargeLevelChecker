package ru.zar1official.chargelevelchecker.data.storage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ChargeStore {
    private val _charge = MutableLiveData<Int>()
    val charge: LiveData<Int> = _charge

    fun changeCharge(value: Int) {
        _charge.value = value
    }

    companion object {
        @Volatile
        private var INSTANCE: ChargeStore? = null

        fun getStorage() =
            INSTANCE ?: synchronized(this) {
                val instance = ChargeStore()
                INSTANCE = instance
                instance
            }
    }
}
