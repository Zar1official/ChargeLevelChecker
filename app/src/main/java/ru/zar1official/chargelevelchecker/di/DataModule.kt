package ru.zar1official.chargelevelchecker.di

import org.koin.dsl.module
import ru.zar1official.chargelevelchecker.data.receiver.BatteryReceiver
import ru.zar1official.chargelevelchecker.data.storage.ChargeStore

private fun provideChargeStore() = ChargeStore.getStorage()

val dataModule = module {
    single {
        BatteryReceiver(storage = get())
    }

    single {
        provideChargeStore()
    }
}