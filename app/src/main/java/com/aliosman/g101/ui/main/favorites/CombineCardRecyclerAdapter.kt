package com.aliosman.g101.ui.main.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
   import androidx.recyclerview.widget.RecyclerView
import com.aliosman.g101.adapter.recyclerAdapter.CombineCardRecyclerData
import com.aliosman.g101.databinding.CardCombineListBinding


internal class CombineCardRecyclerAdapter(private val cardList: List<CombineCardRecyclerData>) :
    RecyclerView.Adapter<CombineCardRecyclerAdapter.CombineCardViewHolder>() {

    class CombineCardViewHolder(val binding: CardCombineListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CombineCardViewHolder {
        val binding = CardCombineListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CombineCardViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CombineCardViewHolder,
        position: Int
    ) {
        val item = cardList[position]
        holder.binding.imgRow1Column1.setImageResource(item.imgResRow1Colm1)
        holder.binding.imgRow1Column2.setImageResource(item.imgResRow1Colm2)
        holder.binding.imgRow2Column1.setImageResource(item.imgResRow2Colm1)
        holder.binding.imgRow1Column2.setImageResource(item.imgResRow2Colm2)
        holder.binding.txtCombineTitle.text = item.title
        holder.binding.txtCombineDesc.text = item.desc
    }

    override fun getItemCount(): Int = cardList.size


}