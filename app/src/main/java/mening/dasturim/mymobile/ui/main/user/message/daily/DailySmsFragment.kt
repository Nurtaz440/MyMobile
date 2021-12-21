package mening.dasturim.mymobile.ui.main.user.message.daily

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
import mening.dasturim.mymobile.databinding.FragmentDailySmsBinding
import mening.dasturim.mymobile.databinding.FragmentSmsPacketsBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.message.sms.SmsPacketsAdapter
import mening.dasturim.mymobile.ui.main.user.message.sms.SmsPacketsVM

class DailySmsFragment : BaseFragment<FragmentDailySmsBinding, DailySmsVM>() {
    private lateinit var internetAdapter: DailySmsAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= DailySmsAdapter {  }


        internetAdapter.setData(Constants.getInterNonStopItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_daily_sms

    override val vm: DailySmsVM
        get() = ViewModelProvider(this).get(DailySmsVM::class.java)


}