package com.aliosman.g101.adapter.viewPagerAdapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aliosman.g101.ui.main.favorites.FavoriteClotheList
import com.aliosman.g101.ui.main.favorites.FavoriteCombineList

class FavoritesPageViewPager(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

        val fragmentList = listOf(
            FavoriteCombineList(),
            FavoriteClotheList()
        )

        override fun createFragment(position: Int): Fragment = fragmentList[position]


        override fun getItemCount(): Int = fragmentList.size

}