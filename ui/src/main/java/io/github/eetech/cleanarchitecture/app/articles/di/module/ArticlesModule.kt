package io.github.eetech.cleanarchitecture.app.articles.di.module

import dagger.Module
import dagger.Provides
import io.github.eetech.cleanarchitecture.app.articles.ArticlesPresenter
import io.github.eetech.cleanarchitecture.domain.articles.GetArticlesListUseCase
import io.github.eetech.cleanarchitecture.mvp.di.scope.PerActivity

@Module
class ArticlesModule {
  @PerActivity
  @Provides
  internal fun provideArticlesPresenter(getArticlesListUseCase: GetArticlesListUseCase) = ArticlesPresenter(getArticlesListUseCase)
}
