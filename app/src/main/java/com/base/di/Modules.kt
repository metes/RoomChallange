package com.base.di

import com.base.commons.SharedPrefHelper
import com.base.repository.network.APIClient
import com.base.ui.activity.MainActivityVM
import com.base.ui.fragment.pilots.detail.PilotDetailVM
import com.base.ui.fragment.pilots.list.PilotVM
import com.base.ui.fragment.splash.SplashVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *  Koin (D.I.) icin gerekli olan modullerin tanimlanmasi
 */
object Modules {

    val mainActivityViewModelModule = module {
        viewModel { MainActivityVM(get(), get()) }
        single { SharedPrefHelper(get()) }
        single { APIClient() }
    }

    val pilotListModule = module {
        viewModel { PilotVM(get(), get()) }
    }
    val pilotDetailsModule = module {
        viewModel { PilotDetailVM(get(), get()) }
    }
    val splashViewModelModule = module {
        viewModel { SplashVM(get(), get()) }
    }


}
