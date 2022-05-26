package com.example.wallpapers.fragmentAdapter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallpapers.R
import com.example.wallpapers.databinding.FragmentAdapterBinding
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"

class FragmentAdapter : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    private lateinit var binding:FragmentAdapterBinding
    private val TAG = "FragmentAdapter"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdapterBinding.inflate(inflater,container,false)
        Picasso.get().load(param1).error(R.drawable.img_2).into(binding.imageview)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentAdapter().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}