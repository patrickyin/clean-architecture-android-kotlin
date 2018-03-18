package io.github.patrickyin.cleanarchitecture.app.articles

import io.github.patrickyin.cleanarchitecture.domain.articles.model.Article
import io.reactivex.observers.DisposableSingleObserver

class ArticlesListObserver(private val presenter: ArticlesPresenter): DisposableSingleObserver<List<Article>>() {
  override fun onSuccess(articlesList: List<Article>) {
    presenter.showArticleList(articlesList)
  }

  override fun onError(e: Throwable) {
    e.printStackTrace()
  }
}
