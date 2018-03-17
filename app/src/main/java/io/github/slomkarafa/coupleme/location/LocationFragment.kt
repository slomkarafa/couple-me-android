package io.github.slomkarafa.coupleme.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import io.github.slomkarafa.coupleme.R
import io.github.slomkarafa.coupleme.di.scope.ActivityScope
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

/**
 * Created by slomkarafa on 17.03.18.
 */
@ActivityScope
class LocationFragment @Inject constructor(): DaggerFragment(), LocationContract.View {

    @Inject
    lateinit var presenter: LocationContract.Presenter

    override fun isActive() = isAdded

    override fun showMap() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showConnectionError() {
        Toast.makeText(context, "Connection Error", Toast.LENGTH_LONG).show()

    }

    override fun showUserLocation(locationDto: LocationDto) {
        this.ownerUsername.setText(locationDto.latitude)
        this.guestUsername.setText(locationDto.longitude)
    }

    override fun onResume() {
        super.onResume()
        presenter.takeView(this)
        presenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        saveButton.setOnClickListener {
            presenter.fetchLocations()}
    }

}