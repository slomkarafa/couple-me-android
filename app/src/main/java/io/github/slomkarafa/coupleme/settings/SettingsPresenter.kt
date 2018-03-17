package io.github.slomkarafa.coupleme.settings

import io.github.slomkarafa.coupleme.data.SettingsRepository
import io.github.slomkarafa.coupleme.util.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by slomkarafa on 15.03.18.
 */

class SettingsPresenter @Inject constructor(
        val schedulerProvider: SchedulerProvider,
        val settingsRepository: SettingsRepository
) : SettingsContract.Presenter {


    val disposable = CompositeDisposable()
    var view: SettingsContract.View? =null

    override fun takeView(view: SettingsContract.View) {
        this.view = view
    }

    override fun subscribe() {

    }

    private fun fetchSettings() {

    }

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun saveSettings(ownerUsername: String, guestUsername: String) {

            view?.showSaveSuccess()
    }

}