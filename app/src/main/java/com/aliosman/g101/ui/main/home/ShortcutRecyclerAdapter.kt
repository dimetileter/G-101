package com.aliosman.g101.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aliosman.g101.databinding.CardFavoriteShortcutBinding

internal class ShortcutRecyclerAdapter(private val shortcutsList: List<FavoriteShortcutData>) :
    RecyclerView.Adapter<ShortcutRecyclerAdapter.ShortcutsViewHolder>() {

    class ShortcutsViewHolder(val binding: CardFavoriteShortcutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
    ): ShortcutsViewHolder {
        val binding = CardFavoriteShortcutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShortcutsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ShortcutsViewHolder,
        position: Int
    ) {
        val item = shortcutsList[position]
        holder.binding.cardFavoriteShortcutBgColor.background = ContextCompat.getDrawable(holder.itemView.context, item.gradiantBackground)
        holder.binding.cardFavoriteShortcutImage.setImageResource(item.imageRes)
        holder.binding.cardFavoriteShortcutTitle.setText(item.titleRes)
    }

    override fun getItemCount(): Int = shortcutsList.size


}