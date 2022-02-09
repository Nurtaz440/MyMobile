package mening.dasturim.mymobile.ui.main.user.ussd

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentUSSDBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class UssdFragment  : BaseFragment<FragmentUSSDBinding, USSDVM>() {
    private lateinit var internetAdapter: UssdAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    internetAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    internetAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    internetAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    internetAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })
        internetAdapter= UssdAdapter(requireContext()) {  }


        internetAdapter.setData(Constants.getUssdItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_u_s_s_d

    override val vm: USSDVM
        get() = ViewModelProvider(this).get(USSDVM::class.java)


}