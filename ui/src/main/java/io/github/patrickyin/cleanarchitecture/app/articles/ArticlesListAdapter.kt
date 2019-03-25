package io.github.patrickyin.cleanarchitecture.app.articles

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import io.github.patrickyin.cleanarchitecture.app.R
import io.github.patrickyin.cleanarchitecture.domain.articles.model.Article
import io.github.patrickyin.cleanarchitecture.domain.articles.model.linkUri


class ArticlesListAdapter(private val context: Context, private val articles: List<Article>) :
  androidx.recyclerview.widget.RecyclerView.Adapter<ArticlesListAdapter.ViewHolder>() {

  class ViewHolder(val button: Button) : androidx.recyclerview.widget.RecyclerView.ViewHolder(button)

  override fun onCreateViewHolder(parent: ViewGroup,
                                  viewType: Int): ViewHolder {
    val button = LayoutInflater.from(context)
      .inflate(R.layout.list_item_article, parent, false) as Button
    return ViewHolder(button)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.button.text = articles[position].title
    holder.button.setOnClickListener {
      articles[position].linkUri()?.let {
        val intent = Intent(Intent.ACTION_VIEW, it)
        startActivity(context, intent, null)
      }
    }
  }

  override fun getItemCount() = articles.size
}
