package io.github.eetech.cleanarchitecture.data.articles.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Articles(
  @SerializedName("items")
  @Expose
  var articles: List<Article>? = null)
