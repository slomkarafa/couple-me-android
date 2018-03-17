package io.github.slomkarafa.coupleme.settings

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
 * Created by slomkarafa on 15.03.18.
 */

@ActivityScope
class SettingsFragment @Inject constructor() : DaggerFragment(), SettingsContract.View {

    @Inject
    lateinit var presenter: SettingsContract.Presenter

    override fun isActive() = isAdded

    private fun showMsg(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun showSaveError() {
        showMsg("Save Error")
    }

    override fun showSaveSuccess() {
        showMsg("Save Success")
    }
    override fun showNotEnoughDataError() {
        showMsg("Enter usernames")
    }
    override fun showOwnerUsername(username: String) {
        this.ownerUsername.setText(username)    }

    override fun showGuestUsername(username: String) {
        this.guestUsername.setText(username)
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
            presenter.saveSettings(this.ownerUsername.text.toString(),
                    this.guestUsername.text.toString())}
    }
}