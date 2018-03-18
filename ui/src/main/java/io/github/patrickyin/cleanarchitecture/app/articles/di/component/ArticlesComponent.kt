package io.github.patrickyin.cleanarchitecture.app.articles.di.component

import dagger.Component
import io.github.patrickyin.cleanarchitecture.app.articles.ArticlesActivity
import io.github.patrickyin.cleanarchitecture.app.articles.di.module.ArticlesModule
import io.github.patrickyin.cleanarchitecture.app.di.component.AppComponent
import io.github.patrickyin.cleanarchitecture.mvp.di.scope.PerActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ArticlesModule::class])
interface ArticlesComponent {
  fun inject(articlesActivity: ArticlesActivity)
}