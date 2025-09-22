package com.aliosman.g101.ui.main.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.aliosman.g101.R
import com.aliosman.g101.databinding.FragmentFavoritesPageBinding

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
    }

    // On Destroy
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // BlurView Effect
    private fun setBlurView() {
        val radius = 25f
        val decorView = requireActivity().window.decorView
        val blurTarget = binding.blurTarget

        val windowBackground = decorView.background
        val blurViewNavBar = binding.blurView

        blurViewNavBar.setupWith(blurTarget)
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)

    }

}