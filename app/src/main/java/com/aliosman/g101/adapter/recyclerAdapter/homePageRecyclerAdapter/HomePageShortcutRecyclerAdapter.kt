package com.aliosman.g101.adapter.recyclerAdapter.homePageRecyclerAdapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aliosman.g101.databinding.CardFavoriteShortcutBinding

class HomePageShortcutRecyclerAdapter(private val shortcutsList: List<HomePageFavoriteShortcut>) :
    RecyclerView.Adapter<HomePageShortcutRecyclerAdapter.ShortcutsViewHolder>() {

    class ShortcutsViewHolder(val binding: CardFavoriteShortcutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
    ): HomePageShortcutRecyclerAdapter.ShortcutsViewHolder {
        val binding = CardFavoriteShortcutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShortcutsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomePageShortcutRecyclerAdapter.ShortcutsViewHolder,
        position: Int
    ) {
        val item = shortcutsList[position]
        holder.binding.cardFavoriteShortcutBgColor.background = ContextCompat.getDrawable(holder.itemView.context, item.gradiantBackground)
        holder.binding.cardFavoriteShortcutImage.setImageResource(item.imageRes)
        holder.binding.cardFavoriteShortcutTitle.setText(item.titleRes)
    }

    override fun getItemCount(): Int = shortcutsList.size


}