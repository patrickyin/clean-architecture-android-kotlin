package io.github.patrickyin.cleanarchitecture.app.articles

import io.github.patrickyin.cleanarchitecture.app.articles.ArticlesListObserver
import io.github.patrickyin.cleanarchitecture.app.articles.ArticlesPresenter
import io.github.patrickyin.cleanarchitecture.domain.articles.model.Article
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(ArticlesPresenter::class)
class ArticlesListObserverTest {
  private lateinit var articlesListObserver: ArticlesListObserver

  @Mock
  lateinit var articlesPresenter: ArticlesPresenter

  @Mock
  lateinit var throwable: Throwable

  @Before
  fun setUp() {
    articlesListObserver = ArticlesListObserver(articlesPresenter)
  }

  @Test
  fun `should show article list when observable emits onSuccess`() {
    val list = emptyList<Article>()
    articlesListObserver.onSuccess(list)
    verify(articlesPresenter).showArticleList(list)
  }

  @Test
  fun `should print stack trace when observable emits onError`() {
    articlesListObserver.onError(throwable)
    verify(throwable).printStackTrace()
  }
}