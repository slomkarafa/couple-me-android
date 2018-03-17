package io.github.slomkarafa.coupleme.location

import io.reactivex.Flowable

/**
 * Created by slomkarafa on 17.03.18.
 */
interface LocationDao {
    fun getUserLocation(username: String): Flowable<LocationDto>

}