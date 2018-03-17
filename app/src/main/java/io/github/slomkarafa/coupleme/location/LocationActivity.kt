package io.github.slomkarafa.coupleme.location

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.github.slomkarafa.coupleme.R
import javax.inject.Inject

/**
 * Created by slomkarafa on 17.03.18.
 */
class LocationActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var locationFragmentProvider: dagger.Lazy<LocationFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        var fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null) {
            fragment = locationFragmentProvider.get()

            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit()
        }
    }
}