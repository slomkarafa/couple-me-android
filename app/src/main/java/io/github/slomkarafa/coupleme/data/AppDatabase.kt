package io.github.slomkarafa.coupleme.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.github.slomkarafa.coupleme.data.model.Settings

/**
 * Created by slomkarafa on 16.03.18.
 */

@Database(entities = arrayOf(Settings::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun settingsDao(): SettingsDao
}