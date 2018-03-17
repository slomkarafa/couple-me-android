package io.github.slomkarafa.coupleme.location

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.slomkarafa.coupleme.di.scope.ActivityScope
import io.github.slomkarafa.coupleme.di.scope.FragmentScope

/**
 * Created by slomkarafa on 17.03.18.
 */

@Module
abstract class LocationModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun locationFragment(): LocationFragment

    @ActivityScope
    @Binds
    abstract fun locationPresenter(presenter: LocationPresenter): LocationContract.Presenter
}

