package com.example.pruebamedialab.view.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdapterViewPager(
    fragmentManager: FragmentManager,
    private val listFragments: ArrayList<Fragment>,
    private val listTitleFragments: ArrayList<String>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount() = listFragments.size

    override fun getItem(position: Int): Fragment {
        return listFragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position > count - 1) return null
        return listTitleFragments[position]
    }
}