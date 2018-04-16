package io.github.patrickyin.cleanarchitecture.app

import android.app.Application
import io.github.patrickyin.cleanarchitecture.app.di.component.AppComponent
import io.github.patrickyin.cleanarchitecture.app.di.component.DaggerAppComponent
import io.github.patrickyin.cleanarchitecture.app.di.module.AppModule

class App : Application() {
  val applicationComponent: AppComponent by lazy {
    DaggerAppComponent.builder()
      .appModule(AppModule(this))
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    initInjector()
  }

  private fun initInjector() {
    applicationComponent.inject(this)
  }
}
