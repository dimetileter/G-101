package com.aliosman.g101.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliosman.g101.R
import com.aliosman.g101.databinding.CardClothesListBinding
import com.aliosman.g101.adapter.recyclerAdapter.ClothesRecyclerData
import com.aliosman.g101.data.entity.Clothes

internal class ClothesListRecyclerAdapter(private val clothesList: List<Clothes>) :
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
        holder.binding.imgClothes.setImageResource(R.drawable.jean_small)
        holder.binding.txtTitle.text = item.clothingName
        holder.binding.txtSubtitle.text = item.clothingDesc
    }

    override fun getItemCount(): Int = clothesList.size

}