package mening.dasturim.mymobile.ui.main.user.message.sms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.databinding.FragmentSmsPacketsBinding
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
        internetAdapter= SmsPacketsAdapter {  }


        internetAdapter.setData(Constants.getInterNonStopItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_sms_packets

    override val vm: SmsPacketsVM
        get() = ViewModelProvider(this).get(SmsPacketsVM::class.java)


}