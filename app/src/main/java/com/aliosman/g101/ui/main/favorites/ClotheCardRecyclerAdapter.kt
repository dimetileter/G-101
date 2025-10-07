package com.aliosman.g101.ui.main.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliosman.g101.adapter.recyclerAdapter.RecyclerAdapter
import com.aliosman.g101.databinding.CardClothesListBinding
import com.aliosman.g101.databinding.CardCombineListBinding
import com.aliosman.g101.adapter.recyclerAdapter.ClothesRecyclerData

internal class ClotheCardRecyclerAdapter(private val clotheList: List<ClothesRecyclerData>):
    RecyclerView.Adapter<ClotheCardRecyclerAdapter.ClotheCardViewHolder>() {

    class ClotheCardViewHolder(val binding: CardClothesListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
    ): ClotheCardViewHolder {
        val binding = CardClothesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClotheCardViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ClotheCardViewHolder,
        position: Int
    ) {
        val item = clotheList[position]
        holder.binding.imgClothes.setImageResource(item.imageRes)
        holder.binding.txtTitle.text = item.title
        holder.binding.txtSubtitle.text = item.subtitle
    }

    override fun getItemCount(): Int = clotheList.size


}