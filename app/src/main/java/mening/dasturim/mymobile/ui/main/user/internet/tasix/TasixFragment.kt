package mening.dasturim.mymobile.ui.main.user.internet.tasix

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentTasixBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class TasixFragment : BaseFragment<FragmentTasixBinding,TasixVM>() {
    private lateinit var tasixAdapter: TasixAdapter
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    tasixAdapter.setColor(R.color.deep_sky_blue_400)
                    tasixAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    tasixAdapter.setColor(R.color.alizarin_700)
                    tasixAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    tasixAdapter.setColor(R.color.vivid_violet_800)
                    tasixAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    tasixAdapter.setColor(R.color.gorse_600)
                    tasixAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })

        tasixAdapter= TasixAdapter(requireContext()) {  }

        tasixAdapter.setData(Constants.getTasixItems())
        binding.rvTasix.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvTasix.adapter=tasixAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_tasix

    override val vm: TasixVM
        get() = ViewModelProvider(this).get(TasixVM::class.java)


}