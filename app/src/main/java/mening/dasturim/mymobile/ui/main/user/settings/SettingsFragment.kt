package mening.dasturim.mymobile.ui.main.user.settings

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
import mening.dasturim.mymobile.databinding.FragmentSettingsBinding
import mening.dasturim.mymobile.databinding.FragmentSmsPacketsBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.message.sms.SmsPacketsAdapter
import mening.dasturim.mymobile.ui.main.user.message.sms.SmsPacketsVM

class SettingsFragment : BaseFragment<FragmentSettingsBinding, SettingsFragmentVM>() {
    private lateinit var internetAdapter: SettingsAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= SettingsAdapter {  }


        internetAdapter.setData(Constants.getSettingsItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_settings

    override val vm: SettingsFragmentVM
        get() = ViewModelProvider(this).get(SettingsFragmentVM::class.java)


}