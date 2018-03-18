package io.github.eetech.cleanarchitecture.app.articles

import io.github.eetech.cleanarchitecture.domain.articles.model.Article

interface ArticlesView {
  fun initialiseView()
  fun showArticleList(articles: List<Article>)
}
