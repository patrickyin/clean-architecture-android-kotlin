package io.github.patrickyin.cleanarchitecture.app.articles

import io.github.patrickyin.cleanarchitecture.domain.articles.GetArticlesListUseCase
import io.github.patrickyin.cleanarchitecture.domain.articles.model.Article
import io.github.patrickyin.cleanarchitecture.mvp.CleanPresenter
import javax.inject.Inject

class ArticlesPresenter @Inject constructor(private val getArticlesListUseCase: GetArticlesListUseCase) : CleanPresenter<ArticlesView>() {

  override fun initialise() {
    getView()?.initialiseView()
    getArticlesListUseCase.execute(ArticlesListObserver(this))
  }

  override fun disposeSubscriptions() {
    getArticlesListUseCase.dispose()
  }

  fun showArticleList(articlesList: List<Article>) {
    getView()?.showArticleList(articlesList)
  }
}
