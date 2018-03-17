package io.github.slomkarafa.coupleme.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import io.github.slomkarafa.coupleme.App
import io.github.slomkarafa.coupleme.location.LocationDataModule
import io.github.slomkarafa.coupleme.util.scheduler.SchedulerModule
import javax.inject.Singleton

/**
 * Created by slomkarafa on 15.03.18.
 */


@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        SchedulerModule::class,
        LocationDataModule::class
        ))
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: App)

    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}