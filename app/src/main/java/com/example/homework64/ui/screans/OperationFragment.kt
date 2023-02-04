package com.example.homework64.ui.screans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.homework64.databinding.FragmentOperationBinding
import com.example.homework64.viewmodel.CounterViewModel

class OperationFragment : Fragment() {

    private lateinit var binding: FragmentOperationBinding
    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CounterViewModel::class.java]
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnMinus.setOnClickListener {
                viewModel.oDecrementClick()
            }
            btnPlus.setOnClickListener {
                viewModel.onIncrementClick()
            }
        }
    }
}