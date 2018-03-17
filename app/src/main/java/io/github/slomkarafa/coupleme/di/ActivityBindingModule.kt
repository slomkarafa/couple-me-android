package io.github.slomkarafa.coupleme.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.slomkarafa.coupleme.di.scope.ActivityScope
import io.github.slomkarafa.coupleme.location.LocationActivity
import io.github.slomkarafa.coupleme.location.LocationModule
import io.github.slomkarafa.coupleme.settings.SettingsActivity
import io.github.slomkarafa.coupleme.settings.SettingsModule

/**
 * Created by slomkarafa on 15.03.18.
 */

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SettingsModule::class))
    abstract fun settingsActivity(): SettingsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(LocationModule::class))
    abstract fun locationActivity(): LocationActivity
}