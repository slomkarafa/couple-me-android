package io.github.slomkarafa.coupleme.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.github.slomkarafa.coupleme.R
import kotlinx.android.synthetic.main.activity.*
import javax.inject.Inject

/**
 * Created by slomkarafa on 15.03.18.
 */

fun Context.settingsIntent(): Intent {
    return Intent(this, SettingsActivity::class.java)
}

class SettingsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var settingsFragmentProvider: dagger.Lazy<SettingsFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

//        setSupportActionBar(toolbar)

        var fragment
                = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            fragment = settingsFragmentProvider.get()

            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit()
        }
    }
}