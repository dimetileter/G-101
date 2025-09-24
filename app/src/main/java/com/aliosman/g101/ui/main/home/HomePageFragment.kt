package com.aliosman.g101.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliosman.g101.R
import com.aliosman.g101.adapter.recyclerAdapter.homePageRecyclerAdapter.HomePageCategoriesRecyclerAdapter
import com.aliosman.g101.adapter.recyclerAdapter.homePageRecyclerAdapter.HomePageCategoriesData
import com.aliosman.g101.adapter.recyclerAdapter.homePageRecyclerAdapter.HomePageFavoriteShortcut
import com.aliosman.g101.adapter.recyclerAdapter.homePageRecyclerAdapter.HomePageShortcutRecyclerAdapter
import com.aliosman.g101.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    private var recyclerAdapterList: HomePageCategoriesRecyclerAdapter? = null
    private var recyclerAdapterShortcuts: HomePageShortcutRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    // Görünümler oluşturktan sonra yapılacaklar buraya
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Verileri veri tabanından çekecek şekilde güncellenecek. Test için şuanlık böyle
        val categoriesList = getClothesCount()
        val shortcutsTest = getShortcutsData()

        recyclerAdapterShortcuts = HomePageShortcutRecyclerAdapter(shortcutsTest)
        binding.recyclerViewShortcuts.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerViewShortcuts.adapter = recyclerAdapterShortcuts

        recyclerAdapterList = HomePageCategoriesRecyclerAdapter(categoriesList)
        binding.recyclerViewList.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewList.adapter = recyclerAdapterList

        // Blur efektini ayarla
        blurEffect()
    }

    // On destroy
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun blurEffect() {
        val radius = 25f
        val decorView = requireActivity().window.decorView

        val blurTarget = binding.blurTarget // BlurTarget
        val windowBackground = decorView.background
        val blurView = binding.blurViewAppbar // Bulanıklık efektini gösterecek BlurView

        blurView.outlineProvider = ViewOutlineProvider.BACKGROUND
        blurView.setClipToOutline(true)
        blurView.setupWith(blurTarget)
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)
    }

    // Get categories info
    private fun getClothesCount(): List<HomePageCategoriesData> {
        return listOf(
            HomePageCategoriesData(R.drawable.dress_small, R.string.dress, R.string.view_your_clothes, 12),
            HomePageCategoriesData(R.drawable.jean_small, R.string.pant, R.string.view_your_clothes, 7),
            HomePageCategoriesData(R.drawable.shoe_small, R.string.shoe, R.string.view_your_clothes, 4),
            HomePageCategoriesData(R.drawable.leather_jacket_small, R.string.jacket, R.string.view_your_clothes, 5),
            HomePageCategoriesData(R.drawable.skirt_small, R.string.skirt, R.string.view_your_clothes, 3),
            HomePageCategoriesData(R.drawable.tshirt_small, R.string.tshirt, R.string.view_your_clothes, 10),
            HomePageCategoriesData(R.drawable.necklace_small, R.string.accessories, R.string.view_your_clothes, 23),
            HomePageCategoriesData(R.drawable.sweater_small, R.string.sweater, R.string.view_your_clothes, 14),
            HomePageCategoriesData(R.drawable.suit_small, R.string.suit, R.string.view_your_clothes, 3),
            HomePageCategoriesData(R.drawable.sungalsses_small, R.string.glasses, R.string.view_your_clothes, 4),
            HomePageCategoriesData(R.drawable.parfume_small, R.string.perfume, R.string.view_your_clothes, 4)
        )
    }

    // Get shortcuts data
    private fun getShortcutsData(): List<HomePageFavoriteShortcut> {
        return listOf(
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_dress, R.drawable.dress_large, R.string.dress),
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_suit, R.drawable.suit_large, R.string.suit),
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_jacket, R.drawable.leather_jacket_large, R.string.jacket),
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_skirt, R.drawable.skirt_large, R.string.skirt),
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_pant, R.drawable.jean_large, R.string.pant),
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_sweater, R.drawable.sweater_large, R.string.sweater),
            HomePageFavoriteShortcut(R.drawable.bg_favorites_shortcut_tshirt, R.drawable.tshirt_large, R.string.tshirt),
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_shirt, R.drawable.shirt_large, R.string.shirt),
            HomePageFavoriteShortcut(R.drawable.bg_favorite_shortcut_shoe, R.drawable.shoe_large, R.string.shoe)

        )
    }

}