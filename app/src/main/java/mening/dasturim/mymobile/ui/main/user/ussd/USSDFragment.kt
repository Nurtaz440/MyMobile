package mening.dasturim.mymobile.ui.main.user.ussd

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
import mening.dasturim.mymobile.databinding.FragmentInternationalBinding
import mening.dasturim.mymobile.databinding.FragmentUSSDBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.message.around.InternationalAdapter
import mening.dasturim.mymobile.ui.main.user.message.around.InternationalVM

class USSDFragment  : BaseFragment<FragmentUSSDBinding, USSDVM>() {
    private lateinit var internetAdapter: USSDAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= USSDAdapter {  }


        internetAdapter.setData(Constants.getUssdItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_u_s_s_d

    override val vm: USSDVM
        get() = ViewModelProvider(this).get(USSDVM::class.java)


}