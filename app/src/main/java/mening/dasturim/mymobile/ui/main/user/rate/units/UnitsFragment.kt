package mening.dasturim.mymobile.ui.main.user.rate.units

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentUNITSBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

 class UnitsFragment : BaseFragment<FragmentUNITSBinding, UnitsFragmentVM>() {
    private lateinit var rateAdapter: UnitsAdapter
    override fun onBound() {

        setUp()
    }

    fun setUp() {
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    rateAdapter.setColor(R.color.deep_sky_blue_400)
                    rateAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    rateAdapter.setColor(R.color.alizarin_700)
                    rateAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    rateAdapter.setColor(R.color.vivid_violet_800)
                    rateAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    rateAdapter.setColor(R.color.gorse_600)
                    rateAdapter.setColorLight(R.color.gorse_100)
                }
            }
        })

        rateAdapter = UnitsAdapter(requireContext()) { }
        rateAdapter.setData(Constants.getRateItems())


        binding.rvUnits.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)




        binding.rvUnits.adapter=rateAdapter
    }

    override fun getLayoutResId() = R.layout.fragment_u_n_i_t_s

    override val vm: UnitsFragmentVM
        get() = ViewModelProvider(this).get(UnitsFragmentVM::class.java)


}