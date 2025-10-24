package com.aliosman.g101.ui.main.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliosman.g101.R
import com.aliosman.g101.adapter.recyclerAdapter.ClothesRecyclerData
import com.aliosman.g101.databinding.FragmentFavoriteClotheListBinding
import com.aliosman.g101.ui.categories.ClothesListRecyclerAdapter

class FavoriteClotheList : Fragment() {

    private var _binding: FragmentFavoriteClotheListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteClotheListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recycler adapter
        val recyclerAdapter =  binding.recyclerView
        recyclerAdapter.layoutManager = LinearLayoutManager(requireContext())
        recyclerAdapter.adapter = ClothesListRecyclerAdapter(emptyList())

    }

    private fun getFavoriteClothes(): List<ClothesRecyclerData> {
        return listOf(
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
            ClothesRecyclerData(R.drawable.dress_small, "Elbise", "Yazlık elbise"),
            ClothesRecyclerData(R.drawable.shirt_small, "Gömlek", "Düz çigili"),
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
            ClothesRecyclerData(R.drawable.shoe_small, "Ayakkabı", "Spor Ayakkabısı"),
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}