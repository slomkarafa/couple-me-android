package io.github.slomkarafa.coupleme.location

import io.github.slomkarafa.coupleme.util.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by slomkarafa on 17.03.18.
 */
class LocationPresenter @Inject constructor(
        val schedulerProvider: SchedulerProvider,
        val locationDao: LocationDao
): LocationContract.Presenter {

    override fun fetchLocations() {
        val guestUsername:String = "test"
        disposable.add(locationDao.getUserLocation(guestUsername)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                        {
                            val view = checkNotNull(view)
                            if(view.isActive()) {
                                view.showUserLocation(it)
                            }
                        },
                        {
                            val view = checkNotNull(view)
                            if(view.isActive()) {
                                view.showConnectionError()
                            }
                        }
                )
        )
    }

    val disposable = CompositeDisposable()
    var view: LocationContract.View? = null

    override fun takeView(view: LocationContract.View) {
        this.view = view
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun getUserLocation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}