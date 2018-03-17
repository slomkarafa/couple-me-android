package io.github.slomkarafa.coupleme.util.mvp

/**
 * Created by slomkarafa on 17.03.18.
 */
interface BasePresenter<T> {
    fun takeView(view: T)
    fun subscribe()
    fun unsubscribe()
}