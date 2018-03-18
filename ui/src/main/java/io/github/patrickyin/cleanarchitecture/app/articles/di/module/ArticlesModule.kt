package io.github.patrickyin.cleanarchitecture.app.articles.di.module

import dagger.Module
import dagger.Provides
import io.github.patrickyin.cleanarchitecture.app.articles.ArticlesPresenter
import io.github.patrickyin.cleanarchitecture.domain.articles.GetArticlesListUseCase
import io.github.patrickyin.cleanarchitecture.mvp.di.scope.PerActivity

@Module
class ArticlesModule {
  @PerActivity
  @Provides
  internal fun provideArticlesPresenter(getArticlesListUseCase: GetArticlesListUseCase) = ArticlesPresenter(getArticlesListUseCase)
}
