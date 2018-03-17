package io.github.slomkarafa.coupleme.data

import io.github.slomkarafa.coupleme.data.model.Settings
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by slomkarafa on 16.03.18.
 */

@Singleton
class SettingsRepositoryImpl @Inject constructor(val settingsDao: SettingsDao) : SettingsRepository {
    override fun get(): Flowable<Settings> {
        return settingsDao.get()
    }

    override fun update(vararg settings: Settings): Completable {
        return Completable.fromCallable { settingsDao.update(*settings) }
    }

    override fun insert(vararg settings: Settings): Completable {
        return Completable.fromCallable { settingsDao.insert(*settings) }
    }

    override fun delete(settings: Settings): Completable {
        return Completable.fromCallable { settingsDao.delete(settings) }
    }

}