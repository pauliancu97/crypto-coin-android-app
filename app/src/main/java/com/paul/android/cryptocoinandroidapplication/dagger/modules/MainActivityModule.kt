package com.paul.android.cryptocoinandroidapplication.dagger.modules

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(
    private val application: Application
) {
    @Provides
    fun applicationProvider() = application
}