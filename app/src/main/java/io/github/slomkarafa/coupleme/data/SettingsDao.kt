package io.github.slomkarafa.coupleme.data

import android.arch.persistence.room.*
import io.github.slomkarafa.coupleme.data.model.Settings
import io.reactivex.Flowable

/**
 * Created by slomkarafa on 16.03.18.
 */
@Dao
interface SettingsDao {

    @Query("SELECT * FROM settings")
    fun get(): Flowable<Settings>

    @Update
    fun update(vararg settings: Settings)

    @Insert
    fun insert(vararg settings: Settings)

    @Delete
    fun delete(settings: Settings)
}