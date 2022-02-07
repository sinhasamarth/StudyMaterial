package com.github.sinhasamarth.studymaterial.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.sinhasamarth.studymaterial.MainViewModel
import com.github.sinhasamarth.studymaterial.R
import com.github.sinhasamarth.studymaterial.databinding.FragmentFinalBinding
import org.koin.android.ext.android.inject

class FinalFragment : Fragment() {

    private val viewModel : MainViewModel by inject()
    private lateinit var binding: FragmentFinalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (viewModel.finalData.key+ "\n "+ viewModel.finalData.value).also { binding.TextViewTitle.text = it }

    }
}