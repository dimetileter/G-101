package com.aliosman.g101.ui.main.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.aliosman.g101.R
import com.aliosman.g101.adapter.recyclerAdapter.CombineCardRecyclerData
import com.aliosman.g101.databinding.CardCombineListBinding
import com.aliosman.g101.databinding.FragmentFavoriteCombineListBinding

class FavoriteCombineList : Fragment() {

    private var _binding: FragmentFavoriteCombineListBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteCombineListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recycler Adapter
        val combineCardList = getCombineData()
        val recyclerAdapter = binding.recyclerView
        recyclerAdapter.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerAdapter.adapter = CombineCardRecyclerAdapter(combineCardList)

    }

    private fun getCombineData(): List<CombineCardRecyclerData> {
        return listOf(
            CombineCardRecyclerData(
                R.drawable.sweater_small,
                R.drawable.jean_small,
                R.drawable.shoe_small,
                R.drawable.parfume_small,
                "School",
                "University",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.leather_jacket_small,
                R.drawable.shirt_small,
                R.drawable.sungalsses_small,
                R.drawable.parfume_small,
                "Job",
                "Monday",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.skirt_small,
                R.drawable.necklace_small,
                R.drawable.parfume_small,
                R.drawable.sungalsses_small,
                "Cafe",
                "With friends",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.dress_small,
                R.drawable.shoe_small,
                R.drawable.parfume_small,
                R.drawable.necklace_small,
                "Picnic",
                "Park",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.skirt_small,
                R.drawable.sweater_small,
                R.drawable.leather_jacket_small,
                R.drawable.shoe_small,
                "Friends",
                "home visit",
                null
            ),
            //--------------------------//
            CombineCardRecyclerData(
                R.drawable.leather_jacket_small,
                R.drawable.shirt_small,
                R.drawable.sungalsses_small,
                R.drawable.parfume_small,
                "Job",
                "Monday",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.sweater_small,
                R.drawable.jean_small,
                R.drawable.shoe_small,
                R.drawable.parfume_small,
                "School",
                "University",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.dress_small,
                R.drawable.shoe_small,
                R.drawable.parfume_small,
                R.drawable.necklace_small,
                "Picnic",
                "Park",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.skirt_small,
                R.drawable.sweater_small,
                R.drawable.leather_jacket_small,
                R.drawable.shoe_small,
                "Friends",
                "home visit",
                null
            ),

            CombineCardRecyclerData(
                R.drawable.sweater_small,
                R.drawable.shoe_small,
                R.drawable.skirt_small,
                R.drawable.sungalsses_small,
                "Home",
                "Weekend",
                null
            ),
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}