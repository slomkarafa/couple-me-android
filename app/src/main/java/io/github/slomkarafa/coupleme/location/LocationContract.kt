package io.github.slomkarafa.coupleme.location

import io.github.slomkarafa.coupleme.util.mvp.BasePresenter
import io.github.slomkarafa.coupleme.util.mvp.BaseView

/**
 * Created by slomkarafa on 17.03.18.
 */
interface LocationContract {

    interface View: BaseView {
        fun showMap()
        fun showUserLocation(locationDto: LocationDto)
        fun showConnectionError()
    }
    interface Presenter: BasePresenter<LocationContract.View>{
        fun getUserLocation()
        fun fetchLocations()
    }
}