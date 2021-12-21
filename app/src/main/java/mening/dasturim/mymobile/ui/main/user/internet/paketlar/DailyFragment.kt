package mening.dasturim.mymobile.ui.main.user.internet.paketlar

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
import mening.dasturim.mymobile.databinding.FragmentDailyBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.internet.nonstop.NonStopAdapter

class DailyFragment : BaseFragment<FragmentDailyBinding,DailyPocketsVM>() {
    private lateinit var dailyAdapter: DailyAdapter
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        dailyAdapter = DailyAdapter {}
        dailyAdapter.setData(Constants.getDailyItems())

        binding.rvDailyStop.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvDailyStop.adapter=dailyAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_daily

    override val vm: DailyPocketsVM
        get() = ViewModelProvider(this).get(DailyPocketsVM::class.java)


}