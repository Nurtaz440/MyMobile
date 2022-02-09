package mening.dasturim.mymobile.ui.main.user.internet.paketlar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentDailyBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class DailyFragment : BaseFragment<FragmentDailyBinding,DailyPocketsVM>() {
    private lateinit var dailyAdapter: DailyAdapter
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    dailyAdapter.setColor(R.color.deep_sky_blue_400)
                    dailyAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    dailyAdapter.setColor(R.color.alizarin_700)
                    dailyAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    dailyAdapter.setColor(R.color.vivid_violet_800)
                    dailyAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    dailyAdapter.setColor(R.color.gorse_600)
                    dailyAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })


        dailyAdapter = DailyAdapter(requireContext()) {}
        dailyAdapter.setData(Constants.getDailyItems())

        binding.rvDailyStop.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvDailyStop.adapter=dailyAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_daily

    override val vm: DailyPocketsVM
        get() = ViewModelProvider(this).get(DailyPocketsVM::class.java)


}