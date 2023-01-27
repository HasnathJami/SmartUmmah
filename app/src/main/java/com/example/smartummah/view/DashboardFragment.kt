package com.example.smartummah.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.smartummah.R
import com.example.smartummah.databinding.FragmentDashboardBinding
import com.example.smartummah.viewmodel.DashboardViewModel

class DashboardFragment : Fragment() {

    lateinit var mContext: Context
    lateinit var mBinding: FragmentDashboardBinding
    lateinit var mViewModel: DashboardViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        mViewModel.setName("Jishan Chowdhury")
        mBinding.viewModel = mViewModel
    }

}