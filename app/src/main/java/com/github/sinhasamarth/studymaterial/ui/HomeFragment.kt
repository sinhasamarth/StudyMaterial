package com.github.sinhasamarth.studymaterial.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.sinhasamarth.studymaterial.MainViewModel
import com.github.sinhasamarth.studymaterial.adapters.HomeRecylerView
import com.github.sinhasamarth.studymaterial.databinding.FragmentHomeBinding
import com.github.sinhasamarth.studymaterial.listerns.onClickView
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(), onClickView {
//    val viewModel: MainViewModel by inject()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapater()
        setListerns()
    }

    private fun setListerns() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        if (!MainViewModel.removeStackData()) {
                            Log.d(MainViewModel.Stackdata.size.toString(), "hii")
                        }
                    }

                }
            )
    }

    private fun setAdapater() {
        MainViewModel.getAllData()
        binding.RecylerView.layoutManager = LinearLayoutManager(requireContext())
        MainViewModel.ApiView.observe(viewLifecycleOwner) {
            Log.d("CLICKED ON ------------", it.toString())
            val adaper = HomeRecylerView(it, 0, this)
            binding.RecylerView.adapter = adaper
            adaper.notifyDataSetChanged()
        }
    }

    override fun onClick(position: Int) {
        MainViewModel.onClickView(position)
    }


}