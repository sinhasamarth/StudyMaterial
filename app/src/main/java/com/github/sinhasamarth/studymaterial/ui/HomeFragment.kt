package com.github.sinhasamarth.studymaterial.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.sinhasamarth.studymaterial.MainViewModel
import com.github.sinhasamarth.studymaterial.R
import com.github.sinhasamarth.studymaterial.Repository
import com.github.sinhasamarth.studymaterial.adapters.HomeRecylerView
import com.github.sinhasamarth.studymaterial.databinding.FragmentHomeBinding
import com.github.sinhasamarth.studymaterial.listerns.onClickView
import com.github.sinhasamarth.studymaterial.model.ResponseModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.lang.Exception

class HomeFragment : Fragment(), onClickView {
    val viewModel: MainViewModel by inject()
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
        addAdapter()
        viewModel.getDataFromApi()
    }


    private fun addAdapter() {
        viewModel.stackResponse.observe(viewLifecycleOwner)
        {
            try {
                val p = HomeRecylerView(
                    it.peek(),
                    0,
                    this
                )
                binding.RecylerView.layoutManager = LinearLayoutManager(requireContext())
                binding.RecylerView.adapter = p
                p.notifyDataSetChanged()

            } catch (e: Exception) {
            }
        }
    }

    override fun onClick(position: Int) {
        if (!viewModel.itemListens(position)) {
            findNavController().navigate(R.id.action_homeFragment2_to_finalFragment2)
        }
    }


}