package io.github.eetech.cleanarchitecture.app.di.module

import dagger.Module
import dagger.Provides
import io.github.eetech.cleanarchitecture.data.Endpoint
import io.github.eetech.cleanarchitecture.data.articles.repository.ArticlesRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  internal fun provideArticleRepository(endpoint: Endpoint): ArticlesRepository = ArticlesRepository(endpoint)
}