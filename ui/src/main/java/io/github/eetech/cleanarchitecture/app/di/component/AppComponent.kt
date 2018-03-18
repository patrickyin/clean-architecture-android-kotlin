package io.github.eetech.cleanarchitecture.app.di.component

import android.content.Context
import dagger.Component
import io.github.eetech.cleanarchitecture.app.App
import io.github.eetech.cleanarchitecture.app.di.module.AppModule
import io.github.eetech.cleanarchitecture.app.di.module.IOModule
import io.github.eetech.cleanarchitecture.data.articles.repository.ArticlesRepository
import io.github.eetech.cleanarchitecture.app.di.module.RepositoryModule
import io.github.eetech.cleanarchitecture.app.di.module.UseCaseModule
import io.github.eetech.cleanarchitecture.data.Endpoint
import io.github.eetech.cleanarchitecture.domain.articles.GetArticlesListUseCase
import io.reactivex.Scheduler
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
  fun inject(app: App)
  fun getApplicationContext(): Context
  fun getEndpoint(): Endpoint

  fun getArticlesListUseCase(): GetArticlesListUseCase
}
