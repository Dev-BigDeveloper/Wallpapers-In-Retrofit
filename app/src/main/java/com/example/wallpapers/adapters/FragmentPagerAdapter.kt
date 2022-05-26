package com.example.wallpapers.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.wallpapers.fragmentAdapter.FragmentAdapter

class FragmentPagerAdapter(fm:FragmentManager,var list:ArrayList<String>) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return FragmentAdapter.newInstance(list[position])
    }
}