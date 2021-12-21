package mening.dasturim.mymobile.ui.main.user.internet.internetNonstop

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
import mening.dasturim.mymobile.databinding.FragmentInterNonstopBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.internet.tasix.TasixAdapter


class InterNonstop : BaseFragment<FragmentInterNonstopBinding,InternetNonstopVM>() {
    private lateinit var internetNonstopAdapter: InternetNonstopAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetNonstopAdapter= InternetNonstopAdapter {  }

        internetNonstopAdapter.setData(Constants.getInterNonStopItems())
        binding.rvInternetNonStop.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternetNonStop.adapter=internetNonstopAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_inter_nonstop

    override val vm: InternetNonstopVM
        get() = ViewModelProvider(this).get(InternetNonstopVM::class.java)


}