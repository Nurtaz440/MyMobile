package mening.dasturim.mymobile.ui.main.user.internet.internetNonstop

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
import mening.dasturim.mymobile.databinding.FragmentInterNonstopBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.internet.tasix.TasixAdapter


class InterNonstop : BaseFragment<FragmentInterNonstopBinding,InternetNonstopVM>() {
    private lateinit var internetNonstopAdapter: InternetNonstopAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    internetNonstopAdapter.setColor(R.color.deep_sky_blue_400)
                    internetNonstopAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    internetNonstopAdapter.setColor(R.color.alizarin_700)
                    internetNonstopAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    internetNonstopAdapter.setColor(R.color.vivid_violet_800)
                    internetNonstopAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    internetNonstopAdapter.setColor(R.color.gorse_600)
                    internetNonstopAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })

        internetNonstopAdapter= InternetNonstopAdapter(requireContext()) {  }

        internetNonstopAdapter.setData(Constants.getInterNonStopItems())
        binding.rvInternetNonStop.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternetNonStop.adapter=internetNonstopAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_inter_nonstop

    override val vm: InternetNonstopVM
        get() = ViewModelProvider(this).get(InternetNonstopVM::class.java)


}