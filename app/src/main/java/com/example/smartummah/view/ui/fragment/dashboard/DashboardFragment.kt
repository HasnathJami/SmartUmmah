package com.example.smartummah.view.ui.fragment.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartummah.R
import com.example.smartummah.application.UserApplication
import com.example.smartummah.databinding.FragmentDashboardBinding
import com.example.smartummah.model.Prayer
import com.example.smartummah.model.PrayerTimes
import com.example.smartummah.view.adapter.PrayerTimeAdapter
import com.example.smartummah.viewmodel.AppViewModelFactory
import com.example.smartummah.viewmodel.DashboardViewModel
import javax.inject.Inject


class DashboardFragment : Fragment() {

    @Inject
    lateinit var appViewModelFactory : AppViewModelFactory

    lateinit var mContext: Context
    lateinit var mBinding: FragmentDashboardBinding
    lateinit var mViewModel: DashboardViewModel
    var list: ArrayList<Prayer> = ArrayList()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponent()
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


        //mViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        mViewModel = ViewModelProvider(this, appViewModelFactory)[DashboardViewModel::class.java]
        mBinding.viewModel = mViewModel
//        var bundle: Bundle = this.requireArguments()
//        var data = bundle.getSerializable("key")

        //subscribeUiToPrayerList(mViewModel.prayerListExtract)
        if (resources.getBoolean(R.bool.is_demo)) {
            Toast.makeText(context, "Fetch from API Call", Toast.LENGTH_LONG).show()
            SubscribeUiToPrayerTimes(mViewModel.prayerTimesLiveData)
        } else {
            subscribeUiToPrayerList(mViewModel.fetchPrayerList())
        }

    }

    private fun initComponent() {
//        val appComponent = DaggerAppComponent.builder()
//            .appModule(AppModule(mContext))
//            .build()
//
//        appComponent.inject(this)
        (requireActivity().application as UserApplication).applicationComponent.inject(this)
    }

    private fun SubscribeUiToPrayerTimes (liveData: LiveData<PrayerTimes>) {
        liveData.observe(viewLifecycleOwner) {value ->
            list.clear()
            list.add(Prayer(prayerName = "Api-Fazr", prayerTime = value.data.timings.Fajr))
            list.add(Prayer(prayerName = "Zuhr", prayerTime = value.data.timings.Dhuhr))
            list.add(Prayer(prayerName = "Asr", prayerTime = value.data.timings.Asr))
            list.add(Prayer(prayerName = "Magrib", prayerTime = value.data.timings.Maghrib))
            list.add(Prayer(prayerName = "Esha", prayerTime = value.data.timings.Isha))
            list.add(Prayer(prayerName = "Sunrise", prayerTime = value.data.timings.Sunrise))
            populateRecyclerView()
        }
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

}