package io.github.patrickyin.cleanarchitecture.mvp

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class CleanPresenter<out T> {
  private var view: T? = null

  abstract fun initialise()
  abstract fun disposeSubscriptions()

  fun getView(): T? = view

  @Suppress("UNCHECKED_CAST")
  fun attachView(view: Any?) {
    this.view = view as T?
  }

  fun detachView() {
    view = null
  }
}

