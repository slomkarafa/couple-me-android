package io.github.slomkarafa.coupleme.data

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by slomkarafa on 16.03.18.
 */
@Module
abstract class DatabaseModule {

    @Singleton
@Provides
fun database(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "coupleme-data").build()
    }

    @Singleton
@Provides
fun settingsDao(database: AppDatabase): SettingsDao {
        return database.settingsDao()
    }
}