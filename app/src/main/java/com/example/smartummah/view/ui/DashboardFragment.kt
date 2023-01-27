package com.example.smartummah.view.ui

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
        mBinding.viewModel = mViewModel

    }

    //   private fun testPrayerTimes() {
//        val today = SimpleDate(GregorianCalendar())
//        val location = Location(23.8198,  90.3659, 6.0, 0)
//        val azan = Azan(location, Method.MUSLIM_LEAGUE)
//        val prayerTimes = azan.getPrayerTimes(today)
//        //val imsaak = azan.getImsaak(today)
//
//        //println("date ---> " + today.day + " / " + today.month + " / " + today.year)
//        Log.d("testFazr",prayerTimes.fajr().toString())
//        Log.d("testZ",prayerTimes.thuhr().toString())
//        Log.d("testA",prayerTimes.assr().toString())
//        Log.d("testM",prayerTimes.maghrib().toString())
//        Log.d("testIsha",prayerTimes.ishaa().toString())
//        Log.d("testSunrise",prayerTimes.shuruq().toString())

//    }

}