package io.github.patrickyin.cleanarchitecture.app.di.component

import android.content.Context
import dagger.Component
import io.github.patrickyin.cleanarchitecture.app.App
import io.github.patrickyin.cleanarchitecture.app.di.module.AppModule
import io.github.patrickyin.cleanarchitecture.app.di.module.IOModule
import io.github.patrickyin.cleanarchitecture.app.di.module.RepositoryModule
import io.github.patrickyin.cleanarchitecture.app.di.module.UseCaseModule
import io.github.patrickyin.cleanarchitecture.data.Endpoint
import io.github.patrickyin.cleanarchitecture.domain.articles.GetArticlesListUseCase
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
  fun inject(app: App)
  fun getApplicationContext(): Context
  fun getEndpoint(): Endpoint

  fun getArticlesListUseCase(): GetArticlesListUseCase
}
