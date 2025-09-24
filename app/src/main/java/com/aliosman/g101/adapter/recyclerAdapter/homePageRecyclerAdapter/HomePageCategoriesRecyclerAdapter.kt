package com.aliosman.g101.adapter.recyclerAdapter.homePageRecyclerAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliosman.g101.databinding.CardMainCategoryCardBinding

class HomePageCategoriesRecyclerAdapter(private val items: List<HomePageCategoriesData>):
    RecyclerView.Adapter<HomePageCategoriesRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardMainCategoryCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = CardMainCategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.binding.imgClothes.setImageResource(item.imageRes)
        holder.binding.txtTitle.setText(item.titleRes)
        holder.binding.txtSubtitle.setText(item.subtitleRes)
        holder.binding.txtCount.text = item.count.toString()  // int → String
    }

    override fun getItemCount(): Int = items.size
}