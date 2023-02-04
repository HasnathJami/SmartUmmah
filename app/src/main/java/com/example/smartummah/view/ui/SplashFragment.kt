package com.example.smartummah.view.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.smartummah.R
import com.example.smartummah.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var mContext: Context
    private lateinit var mBinding: FragmentSplashBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        populateSplashScreen()

    }

    private fun populateSplashScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController(mBinding.root)
                .navigate(R.id.dashboardFragment, null)
            (activity as MainActivity).supportActionBar?.show()
        }, 1500)
        findNavController(mBinding.root).popBackStack(R.id.splashScreenFragment, true);
    }
}