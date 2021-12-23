package mening.dasturim.mymobile.ui.main.user.connect

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
import mening.dasturim.mymobile.databinding.FragmentConnectBinding
import mening.dasturim.mymobile.databinding.FragmentUSSDBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.ussd.USSDAdapter
import mening.dasturim.mymobile.ui.main.user.ussd.USSDVM

class ConnectFragment : BaseFragment<FragmentConnectBinding, ConnectFragmentVM>() {
    private lateinit var internetAdapter: ConnectAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= ConnectAdapter {  }


        internetAdapter.setData(Constants.getUssdItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_connect

    override val vm: ConnectFragmentVM
        get() = ViewModelProvider(this).get(ConnectFragmentVM::class.java)


}