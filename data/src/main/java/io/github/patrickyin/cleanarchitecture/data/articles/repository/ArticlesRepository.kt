package io.github.patrickyin.cleanarchitecture.data.articles.repository

import io.github.patrickyin.cleanarchitecture.data.Endpoint
import io.github.patrickyin.cleanarchitecture.data.articles.model.Article
import io.reactivex.Single
import javax.inject.Inject

class ArticlesRepository @Inject constructor(private val endpoint: Endpoint) {
  fun articles(): Single<List<Article>> = endpoint.getArticlesList()
    .map { it.articles }
}