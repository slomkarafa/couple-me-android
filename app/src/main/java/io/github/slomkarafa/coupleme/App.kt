package io.github.slomkarafa.coupleme

import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.slomkarafa.coupleme.di.DaggerAppComponent

/**
 * Created by slomkarafa on 15.03.18.
 */


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()

        appComponent.inject(this)
        return  appComponent
    }
}