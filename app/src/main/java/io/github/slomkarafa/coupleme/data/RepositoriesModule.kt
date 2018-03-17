package io.github.slomkarafa.coupleme.data

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by slomkarafa on 16.03.18.
 */

@Module
abstract class RepositoriesModule {

    @Singleton@Binds
    abstract fun settingsRepository(repo: SettingsRepositoryImpl) : SettingsRepository
}