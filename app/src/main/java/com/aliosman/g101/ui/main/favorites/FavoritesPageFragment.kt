package com.aliosman.g101.ui.main.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.aliosman.g101.R
import com.aliosman.g101.databinding.FragmentFavoritesPageBinding
import java.awt.font.TextAttribute

class FavoritesPageFragment : Fragment() {

    private var _binding: FragmentFavoritesPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // BlurEfektini Ayarla
        setBlurView()

        // Settle icon of segmented bar button
        horizontalSegmentedButtonsImplementation()


    }

    // On Destroy
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // BlurView Effect
    private fun setBlurView() {
        val radius = 20f
        val decorView = requireActivity().window.decorView
        val blurTarget = binding.blurTarget

        val windowBackground = decorView.background
        val blurViewNavBar = binding.blurView

        blurViewNavBar.setupWith(blurTarget)
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)

    }

    // Place icons
    private fun horizontalSegmentedButtonsImplementation() {

        val clotheBar = binding.btnFavoriteBar
        val combineBar = binding.btnCombineBar
        val segmentedBars = listOf(clotheBar.segmentedBar, combineBar.segmentedBar)

        // Palce text and remove unnecessarily icons
        clotheBar.apply {
            segmentedBar.isSelected = true
            showFragment(FavoriteClotheList())
            txtButtonText.apply {
                setText(R.string.favorite_clothes)
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            icon.visibility = View.GONE
        }

        combineBar.apply {
            txtButtonText.apply{
                setText(R.string.favorites_combines)
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            icon.visibility = View.GONE
        }


        // // Listen all bars, if clicked any one of them then apply that steps:
        segmentedBars.forEachIndexed { index, bar ->
            // Before, make all buttons unselected
            bar.setOnClickListener {
                segmentedBars.forEach { it.isSelected = false }

                // Then, make selected that clicked one
                bar.isSelected = true
                when (index) {
                    0 -> {showFragment(FavoriteClotheList())}
                    1 -> {showFragment(FavoriteCombineList())}
                }
            }
        }

    }

    // Fetch the fragment
    private fun showFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.favorites_container, fragment)
            .commit()
    }

}