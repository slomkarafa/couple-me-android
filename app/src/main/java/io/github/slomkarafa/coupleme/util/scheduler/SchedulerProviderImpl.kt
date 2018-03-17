package io.github.slomkarafa.coupleme.util.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by slomkarafa on 16.03.18.
 */
@Singleton
class SchedulerProviderImpl @Inject constructor(): SchedulerProvider {
    override fun computation() = Schedulers.computation()

    override fun io() = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

}