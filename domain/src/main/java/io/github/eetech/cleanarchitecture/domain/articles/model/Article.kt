package io.github.eetech.cleanarchitecture.domain.articles.model

import android.net.Uri

data class Article(var title: String? = null,
                   var pubDate: String? = null,
                   var link: String? = null)

fun Article.linkUri(): Uri? = Uri.parse(link)