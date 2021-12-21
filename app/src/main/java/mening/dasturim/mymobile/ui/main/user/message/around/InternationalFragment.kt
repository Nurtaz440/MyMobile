package mening.dasturim.mymobile.ui.main.user.message.around

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
import mening.dasturim.mymobile.databinding.FragmentInternationalBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.message.daily.DailySmsAdapter
import mening.dasturim.mymobile.ui.main.user.message.daily.DailySmsVM

class InternationalFragment  : BaseFragment<FragmentInternationalBinding, InternationalVM>() {
    private lateinit var internetAdapter: InternationalAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= InternationalAdapter {  }


        internetAdapter.setData(Constants.getInterNonStopItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_international

    override val vm: InternationalVM
        get() = ViewModelProvider(this).get(InternationalVM::class.java)


}