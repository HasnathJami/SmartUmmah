package com.example.smartummah.view.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartummah.R
import com.example.smartummah.databinding.FragmentDashboardBinding
import com.example.smartummah.di.AppModule
import com.example.smartummah.di.DaggerAppComponent
import com.example.smartummah.model.Prayer
import com.example.smartummah.view.adapter.PrayerTimeAdapter
import com.example.smartummah.viewmodel.DashboardViewModel
import javax.inject.Inject


class DashboardFragment : Fragment() {

    lateinit var mContext: Context
    lateinit var mBinding: FragmentDashboardBinding
    lateinit var mViewModel: DashboardViewModel
    var list: ArrayList<Prayer> = ArrayList()

    @Inject
    lateinit var myContext: Context

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

    @RequiresApi(33)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initComponent()

        mViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        mBinding.viewModel = mViewModel
        var bundle: Bundle = this.requireArguments()
        var data = bundle.getSerializable("key")
        //Log.d("checkKey", data.toString())

        //subscribeUiToPrayerList(mViewModel.getPrayerList())
        subscribeUiToPrayerList(mViewModel.prayerListExtract)
    }

    private fun initComponent(){
       val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(mContext))
            .build()

       appComponent.inject(this)
    }

    private fun subscribeUiToPrayerList(liveData: LiveData<List<Prayer>>) {
        liveData.observe(viewLifecycleOwner) { value ->
            list.clear()
            list.addAll(value)
            populateRecyclerView();
        }
    }

    private fun populateRecyclerView() {
        val adapter = PrayerTimeAdapter(list)
        mBinding.rvPrayerTimes.setHasFixedSize(true)
        mBinding.rvPrayerTimes.layoutManager = LinearLayoutManager(mContext)
        mBinding.rvPrayerTimes.adapter = adapter
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