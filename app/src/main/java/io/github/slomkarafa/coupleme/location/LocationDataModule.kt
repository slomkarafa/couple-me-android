package io.github.slomkarafa.coupleme.location

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.slomkarafa.coupleme.di.NetModule
import io.github.slomkarafa.coupleme.di.scope.ActivityScope
import io.github.slomkarafa.coupleme.di.scope.FragmentScope
import io.github.slomkarafa.coupleme.settings.SettingsContract
import javax.inject.Singleton

/**
 * Created by slomkarafa on 17.03.18.
 */
@Module(includes = arrayOf(
        NetModule::class
))
abstract class LocationDataModule {

    @Binds
    @Singleton
    abstract fun bindLocationDao(locationDto: LocationDto): LocationDao

}
