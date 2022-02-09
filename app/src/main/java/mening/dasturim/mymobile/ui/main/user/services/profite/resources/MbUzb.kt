package mening.dasturim.mymobile.ui.main.user.services.profite.resources

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentMbUzbBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class MbUzb : BaseFragment<FragmentMbUzbBinding,MbUzbVM>() {
    private lateinit var mbUzbAdapter: MbUzbAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    mbUzbAdapter.setColor(R.color.deep_sky_blue_400)
                    mbUzbAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    mbUzbAdapter.setColor(R.color.alizarin_700)
                    mbUzbAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    mbUzbAdapter.setColor(R.color.vivid_violet_800)
                    mbUzbAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    mbUzbAdapter.setColor(R.color.gorse_600)
                    mbUzbAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })

        mbUzbAdapter= MbUzbAdapter(requireContext()) {  }
        mbUzbAdapter.setData(Constants.getInternetPocketsItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=mbUzbAdapter
    }
    override fun getLayoutResId()=R.layout.fragment_mb_uzb

    override val vm: MbUzbVM
        get() = ViewModelProvider(this).get(MbUzbVM::class.java)


}