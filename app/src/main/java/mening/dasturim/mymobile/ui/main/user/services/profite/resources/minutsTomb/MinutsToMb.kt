package mening.dasturim.mymobile.ui.main.user.services.profite.resources.minutsTomb

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentMinutsToMbBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class MinutsToMb : BaseFragment<FragmentMinutsToMbBinding,MinutsToMbVM>() {
    private lateinit var myAdapter: MinutsToMbAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    myAdapter.setColor(R.color.deep_sky_blue_400)
                    myAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    myAdapter.setColor(R.color.alizarin_700)
                    myAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    myAdapter.setColor(R.color.vivid_violet_800)
                    myAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    myAdapter.setColor(R.color.gorse_600)
                    myAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })
        myAdapter= MinutsToMbAdapter(requireContext()) {  }
        myAdapter.setData(Constants.getInternetPocketsItems())
        binding.rvInternet.apply {
            layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter=myAdapter
        }

    }
    override fun getLayoutResId()=R.layout.fragment_minuts_to_mb

    override val vm: MinutsToMbVM
        get() = ViewModelProvider(this).get(MinutsToMbVM::class.java)


}