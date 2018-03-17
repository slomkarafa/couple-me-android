package io.github.slomkarafa.coupleme.location

import io.github.slomkarafa.coupleme.util.scheduler.SchedulerProvider
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by slomkarafa on 17.03.18.
 */
class LocationDaoImpl @Inject constructor(
        private val locationService: LocationService,
        val schedulerProvider: SchedulerProvider
): LocationDao {
    override fun getUserLocation(username: String): Flowable<LocationDto> {
        return locationService.getUserLocation(username)
                .subscribeOn(schedulerProvider.io())
                .map { it }
    }

}