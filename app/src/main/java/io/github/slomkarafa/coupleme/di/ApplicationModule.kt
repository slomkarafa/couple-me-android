package io.github.slomkarafa.coupleme.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by slomkarafa on 15.03.18.
 */


@Module
abstract class ApplicationModule {

    @Binds
internal abstract fun bindContext(application: Application) : Context
}