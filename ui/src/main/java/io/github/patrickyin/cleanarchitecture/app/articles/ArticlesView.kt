package io.github.patrickyin.cleanarchitecture.app.articles

import io.github.patrickyin.cleanarchitecture.domain.articles.model.Article

interface ArticlesView {
  fun initialiseView()
  fun showArticleList(articles: List<Article>)
}
