package com.aliosman.g101.adapter.viewPagerAdapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aliosman.g101.ui.main.add.AddPageFragment
import com.aliosman.g101.ui.main.combine.CombinePageFragment
import com.aliosman.g101.ui.main.favorites.FavoritesPageFragment
import com.aliosman.g101.ui.main.home.HomePageFragment

class MainPagesViewPager(activity: AppCompatActivity):
    FragmentStateAdapter(activity) {

        val fragmentList = listOf(
            HomePageFragment(),
            CombinePageFragment(),
            FavoritesPageFragment(),
            AddPageFragment()
        )

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    override fun getItemCount(): Int = fragmentList.size

}