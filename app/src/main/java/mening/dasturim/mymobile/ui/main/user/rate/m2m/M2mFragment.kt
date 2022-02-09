package mening.dasturim.mymobile.ui.main.user.rate.m2m


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentM2MBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class M2mFragment : BaseFragment<FragmentM2MBinding,M2mVM>() {
    private lateinit var m2mAdapter: M2mAdapter
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    m2mAdapter.setColor(R.color.deep_sky_blue_400)
                    m2mAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    m2mAdapter.setColor(R.color.alizarin_700)
                    m2mAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    m2mAdapter.setColor(R.color.vivid_violet_800)
                    m2mAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    m2mAdapter.setColor(R.color.gorse_600)
                    m2mAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })


        m2mAdapter = M2mAdapter(requireContext()) {}
        m2mAdapter.setData(Constants.getM2MItems())

        binding.rvM2m.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvM2m.adapter=m2mAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_m2_m
    override val vm: M2mVM
        get() = ViewModelProvider(this).get(M2mVM::class.java)


}