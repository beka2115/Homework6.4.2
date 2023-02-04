package com.example.homework64.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.homework64.adapter.ViewPagerAdapter
import com.example.homework64.databinding.FragmentViewPagerBinding
import com.example.homework64.ui.screans.HistoryFragment
import com.example.homework64.ui.screans.OperationFragment
import com.example.homework64.ui.screans.ResultFragment
import com.example.homework64.viewmodel.CounterViewModel

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private var fragmentList = arrayListOf<Fragment>(
        OperationFragment(), ResultFragment(), HistoryFragment()
    )
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        adapter = ViewPagerAdapter(
            fragmentList, requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter
    }

}