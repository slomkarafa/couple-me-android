package io.github.slomkarafa.coupleme.util.scheduler

import io.reactivex.Scheduler

/**
 * Created by slomkarafa on 16.03.18.
 */
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

}