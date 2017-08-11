package io.github.eetech.cleanarchitecture.app.articles

import io.github.eetech.cleanarchitecture.domain.articles.GetArticlesListUseCase
import io.github.eetech.cleanarchitecture.domain.articles.model.Article
import io.github.eetech.cleanarchitecture.mvp.CleanPresenter
import io.reactivex.observers.DisposableSingleObserver
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
