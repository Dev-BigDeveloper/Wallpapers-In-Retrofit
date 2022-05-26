package com.example.wallpapers.fragments

import android.graphics.Color
import android.hardware.lights.LightState
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallpapers.R
import com.example.wallpapers.adapters.FragmentPagerAdapter
import com.example.wallpapers.databinding.FragmentHomeBinding
import com.example.wallpapers.databinding.TabItemBinding
import com.google.android.material.tabs.TabLayout

private const val ARG_PARAM1 = "param1"

class HomeFragment : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    private lateinit var binding:FragmentHomeBinding
    private lateinit var adapter:FragmentPagerAdapter
    private lateinit var itemTabBinding:TabItemBinding
    private lateinit var list:List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val list = ArrayList<String>()
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/VhoeJX9BD1b472XOznab7jN-hyGmAikp_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/F48UX70Tzbf67TNyHPFFxg7uLYdC-PW5_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/yUc4kaWxJsChZbcycjSASbotuQEs4_Hd_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/aMAjdF32pwhPk3IRfl1XcKhPduq4alnh_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/4F_pqcPR6nYuk8IfIKiegx5pOgwEMyDH_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/oh-_WYqgBbgjExy7y1nvlrX1HIoS4AHJ_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/PuRq0ovJpITRaYh-K8rLbEY-pydgIqJo_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/qgH_JRTt_ZlRNzhVbHGut3nX6YsSh1Ei_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/8/titAydG7rWvBL50kOUJvLiVP8S5ox9Iy_medium.jpg")
        adapter = FragmentPagerAdapter(parentFragmentManager,list)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        setTabs(inflater,container)
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var itemBinding:TabItemBinding = TabItemBinding.bind(tab!!.customView!!)
                itemBinding.text.setTextColor(Color.WHITE)
                itemBinding.tv.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var itemBinding:TabItemBinding = TabItemBinding.bind(tab!!.customView!!)
                itemBinding.text.setTextColor(Color.parseColor("#AFADAD"))
                itemBinding.tv.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        return binding.root
    }

    private fun setTabs(inflater: LayoutInflater,container: ViewGroup?) {
        var tabCount:Int = binding.tabLayout.tabCount
        val titleList = ArrayList<String>()
        titleList.add("ALL")
        titleList.add("NEW")
        titleList.add("ANIMALS")
        titleList.add("TECHNOLOGY")
        titleList.add("NATURE")
        titleList.add("HELLO")
        titleList.add("ALEX")
        titleList.add("HAMIDULLO")
        titleList.add("JAHONGIR")
        for (i in 0 until tabCount){
            var tab:TabLayout.Tab = binding.tabLayout.getTabAt(i)!!
            itemTabBinding = TabItemBinding.inflate(inflater,container,false)
            tab.customView = itemTabBinding.root
            itemTabBinding.text.text = titleList[i]
            if (i == 0){
                itemTabBinding.tv.visibility = View.VISIBLE
                itemTabBinding.text.setTextColor(Color.WHITE)
            }else{
                itemTabBinding.tv.visibility = View.INVISIBLE
                itemTabBinding.text.setTextColor(Color.parseColor("#AFADAD"))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}