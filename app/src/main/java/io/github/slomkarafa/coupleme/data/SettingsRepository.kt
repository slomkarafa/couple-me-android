package io.github.slomkarafa.coupleme.data

import io.github.slomkarafa.coupleme.data.model.Settings
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by slomkarafa on 16.03.18.
 */

interface SettingsRepository {

    fun get(): Flowable<Settings>

    fun update(vararg settings: Settings): Completable

    fun insert(vararg settings: Settings): Completable

    fun delete(settings: Settings): Completable
}