package io.github.slomkarafa.coupleme.util.scheduler

import io.reactivex.schedulers.Schedulers

/**
 * Created by slomkarafa on 16.03.18.
 */
class SchedulerProviderTestImpl: SchedulerProvider {

    override fun computation() = Schedulers.trampoline()

    override fun io() = Schedulers.trampoline()

    override fun ui() = Schedulers.trampoline()

}