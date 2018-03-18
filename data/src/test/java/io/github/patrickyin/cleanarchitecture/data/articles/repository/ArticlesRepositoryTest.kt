package io.github.patrickyin.cleanarchitecture.data.articles.repository

import io.github.patrickyin.cleanarchitecture.data.Endpoint
import io.github.patrickyin.cleanarchitecture.data.articles.model.Article
import io.github.patrickyin.cleanarchitecture.data.articles.model.Articles
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(Articles::class, Article::class)
class ArticlesRepositoryTest {

  lateinit var articlesRepository: ArticlesRepository

  @Mock
  lateinit var endpoint: Endpoint

  @Mock
  lateinit var articles: Articles

  @Mock
  lateinit var article: Article

  lateinit var articlesList: List<Article>

  @Before
  fun setUp() {
    articlesList = listOf(article)

    `when`(articles.articles)
      .thenReturn(articlesList)
    `when`(endpoint.getArticlesList())
      .thenReturn(Single.just(articles))

    articlesRepository = ArticlesRepository(endpoint)
  }

  @Test
  fun `should map articles field to the root level`() {
    val observer = TestObserver<List<Article>>()
    articlesRepository.articles()
      .subscribe(observer)
    observer.assertNoErrors()
    observer.assertComplete()
    observer.assertValueAt(0, articlesList)
  }
}