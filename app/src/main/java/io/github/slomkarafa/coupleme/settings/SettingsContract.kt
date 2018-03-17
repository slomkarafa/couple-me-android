package io.github.slomkarafa.coupleme.settings

import io.github.slomkarafa.coupleme.util.mvp.BasePresenter
import io.github.slomkarafa.coupleme.util.mvp.BaseView

/**
 * Created by slomkarafa on 15.03.18.
 */
interface SettingsContract {

    interface View : BaseView {
        fun showOwnerUsername(username: String)
        fun showGuestUsername(username: String)
        fun showSaveError()
        fun showSaveSuccess()
        fun showNotEnoughDataError()
    }

    interface Presenter : BasePresenter<SettingsContract.View> {
        fun saveSettings(ownerUsername: String, guestUsername: String)
    }
}