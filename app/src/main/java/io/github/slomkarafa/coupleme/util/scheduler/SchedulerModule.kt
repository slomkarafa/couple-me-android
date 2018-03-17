package io.github.slomkarafa.coupleme.util.scheduler

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by slomkarafa on 16.03.18.
 */
@Module
abstract class SchedulerModule {

    @Singleton
    @Binds
    abstract fun schedulerProvider(provider: SchedulerProviderImpl): SchedulerProvider
}