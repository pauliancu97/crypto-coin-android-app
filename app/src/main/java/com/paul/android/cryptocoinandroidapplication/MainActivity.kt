package com.paul.android.cryptocoinandroidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paul.android.cryptocoinandroidapplication.dagger.component.ApplicationComponent
import com.paul.android.cryptocoinandroidapplication.dagger.component.DaggerApplicationComponent
import com.paul.android.cryptocoinandroidapplication.dagger.modules.MainActivityModule
import com.paul.android.cryptocoinandroidapplication.repositories.CurrenciesRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var currenciesRepository: CurrenciesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        applicationComponent = DaggerApplicationComponent.builder()
            .mainActivityModule(MainActivityModule(application))
            .build()
        applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}