package mening.dasturim.mymobile.ui.main.user.message.sms

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
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.databinding.FragmentSmsPacketsBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.internet.internet.InternetAdapter
import mening.dasturim.mymobile.ui.main.user.internet.internet.InternetVM
import mening.dasturim.mymobile.ui.main.user.message.daily.DailySmsVM

class SmsPacketsFragment : BaseFragment<FragmentSmsPacketsBinding, SmsPacketsVM>() {
    private lateinit var internetAdapter: SmsPacketsAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    internetAdapter.setColor(R.color.deep_sky_blue_400)
                    internetAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    internetAdapter.setColor(R.color.alizarin_700)
                    internetAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    internetAdapter.setColor(R.color.vivid_violet_800)
                    internetAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    internetAdapter.setColor(R.color.gorse_600)
                    internetAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })
        internetAdapter= SmsPacketsAdapter(requireContext()) {  }


        internetAdapter.setData(Constants.getInterNonStopItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_sms_packets

    override val vm: SmsPacketsVM
        get() = ViewModelProvider(this).get(SmsPacketsVM::class.java)


}