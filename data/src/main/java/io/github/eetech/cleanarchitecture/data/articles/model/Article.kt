package io.github.eetech.cleanarchitecture.data.articles.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Article(
  @SerializedName("title")
  @Expose
  var title: String? = null,
  @SerializedName("pubDate")
  @Expose
  var pubDate: String? = null,
  @SerializedName("link")
  @Expose
  var link: String? = null,
  @SerializedName("author")
  @Expose
  var author: String? = null,
  @SerializedName("thumbnail")
  @Expose
  var thumbnail: String? = null,
  @SerializedName("categories")
  @Expose
  var categories: List<String>? = null)
