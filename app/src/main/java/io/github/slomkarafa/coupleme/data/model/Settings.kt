package io.github.slomkarafa.coupleme.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by slomkarafa on 16.03.18.
 */

@Entity
data class Settings(
        @PrimaryKey
        var ownerUsername: String,
        var guestUsername: String
)