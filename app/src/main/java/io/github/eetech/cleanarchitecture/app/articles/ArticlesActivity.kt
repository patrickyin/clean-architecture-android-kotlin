package io.github.eetech.cleanarchitecture.app.articles

import android.support.v7.widget.LinearLayoutManager
import io.github.eetech.cleanarchitecture.app.R
import io.github.eetech.cleanarchitecture.app.App
import io.github.eetech.cleanarchitecture.app.articles.di.component.DaggerArticlesComponent
import io.github.eetech.cleanarchitecture.app.articles.di.module.ArticlesModule
import io.github.eetech.cleanarchitecture.domain.articles.model.Article
import io.github.eetech.cleanarchitecture.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_articles.*

class ArticlesActivity : CleanActivity<ArticlesPresenter>(), ArticlesView {
  override fun getLayout(): Int = R.layout.activity_articles

  override fun initInjector() {
    DaggerArticlesComponent.builder()
      .appComponent((application as App).applicationComponent)
      .articlesModule(ArticlesModule())
      .build()
      .inject(this)
  }

  override fun initialiseView() {
    articles_list_recycler_view.apply {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(this@ArticlesActivity)
    }
  }

  override fun showArticleList(articles: List<Article>) {
    articles_list_recycler_view.adapter = ArticlesListAdapter(this, articles)
  }
}
