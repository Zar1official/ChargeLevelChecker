package ru.zar1official.chargelevelchecker.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.zar1official.chargelevelchecker.ui.theme.screens.battery.BatteryViewModel

val appModule = module {
    viewModel {
        BatteryViewModel(store = get())
    }
}