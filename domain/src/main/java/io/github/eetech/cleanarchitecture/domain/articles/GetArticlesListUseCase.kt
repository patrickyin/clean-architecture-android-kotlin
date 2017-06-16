package io.github.eetech.cleanarchitecture.domain.articles

import io.github.eetech.cleanarchitecture.data.articles.repository.ArticlesRepository
import io.github.eetech.cleanarchitecture.domain.UseCase
import io.github.eetech.cleanarchitecture.domain.articles.model.Article
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetArticlesListUseCase @Inject constructor(private val articlesRepository: ArticlesRepository,
                                                 subscribeScheduler: Scheduler,
                                                 postExecutionScheduler: Scheduler) : UseCase<List<Article>, Unit>(subscribeScheduler, postExecutionScheduler) {

  override fun buildUseCaseSingle(params: Unit?): Single<List<Article>> = articlesRepository.articles()
    .map {
      it.map { Article(it.title, it.pubDate, it.link) }
    }
}
