package com.aliosman.g101.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliosman.g101.databinding.CardClothesListBinding

internal class ClothesListRecyclerAdapter(private val clothesList: List<ClothesRecyclerData>) :
    RecyclerView.Adapter<ClothesListRecyclerAdapter.ClothesListViewHolder>() {

    class ClothesListViewHolder(val binding: CardClothesListBinding ): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClothesListViewHolder {
        val binding = CardClothesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClothesListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ClothesListViewHolder,
        position: Int
    ) {
        val item = clothesList[position]
        holder.binding.imgClothes.setImageResource(item.imageRes)
        holder.binding.txtTitle.setText(item.titleRes)
        holder.binding.txtSubtitle.setText(item.subtitleRes)
    }

    override fun getItemCount(): Int = clothesList.size

}