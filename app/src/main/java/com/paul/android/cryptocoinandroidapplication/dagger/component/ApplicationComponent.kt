package com.paul.android.cryptocoinandroidapplication.dagger.component

import android.app.Application
import com.paul.android.cryptocoinandroidapplication.MainActivity
import com.paul.android.cryptocoinandroidapplication.dagger.modules.DatabaseModule
import com.paul.android.cryptocoinandroidapplication.dagger.modules.MainActivityModule
import com.paul.android.cryptocoinandroidapplication.dagger.modules.ServicesModule
import com.paul.android.cryptocoinandroidapplication.ui.CurrenciesFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    ServicesModule::class,
    DatabaseModule::class,
    MainActivityModule::class]
)
@Singleton
interface ApplicationComponent{
    fun application(): Application

    fun inject(mainActivity: MainActivity)

    fun inject(currenciesFragment: CurrenciesFragment)
}