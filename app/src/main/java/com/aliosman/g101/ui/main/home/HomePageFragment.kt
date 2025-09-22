package com.aliosman.g101.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.aliosman.g101.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

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

        // Hata buradaydı: getWindow() yerine requireActivity().window kullanmalısınız.
        val decorView = requireActivity().window.decorView

        val blurTarget = binding.blurTarget // Listenizin veya kaydırılabilir View'inizin kendisi
        val windowBackground = decorView.background
        val blurView = binding.blurViewAppbar // Bulanıklık efektini gösterecek BlurView

        blurView.outlineProvider = ViewOutlineProvider.BACKGROUND
        blurView.setClipToOutline(true)
        blurView.setupWith(blurTarget)
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)
    }

}