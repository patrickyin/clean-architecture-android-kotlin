package io.github.eetech.cleanarchitecture.app.articles

import io.github.eetech.cleanarchitecture.domain.articles.GetArticlesListUseCase
import io.github.eetech.cleanarchitecture.domain.articles.model.Article
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(GetArticlesListUseCase::class)
class ArticlesPresenterTest {
  private lateinit var presenter: ArticlesPresenter

  @Suppress("UNCHECKED_CAST")
  private fun <T> any(type: Class<T>): T {
    Mockito.any<T>(type)
    return null as T
  }

  @Mock
  lateinit var getArticlesListUseCase: GetArticlesListUseCase

  @Mock
  lateinit var view: ArticlesView

  @Before
  fun setUp() {
    presenter = ArticlesPresenter(getArticlesListUseCase)
    presenter.attachView(view)
  }

  @Test
  fun `should init view`() {
    presenter.initialise()
    verify(view).initialiseView()
  }

  @Test
  fun `should dispose subscription`() {
    presenter.disposeSubscriptions()
    verify(getArticlesListUseCase).dispose()
  }

  @Test
  fun `should execute usecase when initialise is invoked`() {
    presenter.initialise()
    verify(getArticlesListUseCase).execute(any(ArticlesListObserver::class.java), ArgumentMatchers.isNull())
  }

  @Test
  fun `should set articles list to view`() {
    val list = emptyList<Article>()
    presenter.showArticleList(list)
    verify(view).showArticleList(list)
  }
}