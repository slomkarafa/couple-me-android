package io.github.slomkarafa.coupleme.settings

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.slomkarafa.coupleme.di.scope.ActivityScope
import io.github.slomkarafa.coupleme.di.scope.FragmentScope

/**
 * Created by slomkarafa on 15.03.18.
 */

@Module
abstract class SettingsModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun settingsFragment(): SettingsFragment

    @ActivityScope
    @Binds
    abstract fun settingsPresenter(presenter: SettingsPresenter): SettingsContract.Presenter

}