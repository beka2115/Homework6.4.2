package com.example.homework64.ui.screans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework64.adapter.HistoryAdapter
import com.example.homework64.databinding.FragmentHistoryBinding
import com.example.homework64.viewmodel.CounterViewModel

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var viewModel: CounterViewModel
    private val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CounterViewModel::class.java]
        initAdapter()
        observer()
    }

    private fun initAdapter() {
        binding.apply {
            recyclerCount.layoutManager = LinearLayoutManager(context)
            recyclerCount.adapter = adapter
        }
    }

    private fun observer() {
        viewModel.history.observe(viewLifecycleOwner) {
            adapter.getHistory(it)
        }
    }
}