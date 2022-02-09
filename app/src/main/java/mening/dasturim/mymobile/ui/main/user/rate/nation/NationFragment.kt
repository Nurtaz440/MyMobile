package mening.dasturim.mymobile.ui.main.user.rate.nation

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentNationBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class NationFragment : BaseFragment<FragmentNationBinding,NationVM>() {
    private lateinit var nationAdapter: NationAdapter

    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    nationAdapter.setColor(R.color.deep_sky_blue_400)
                    nationAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                 Companies.MOBIUZ -> {
                    nationAdapter.setColor(R.color.alizarin_700)
                    nationAdapter.setColorLight(R.color.alizarin_100)
                }
                 Companies.UCELL -> {
                    nationAdapter.setColor(R.color.vivid_violet_800)
                    nationAdapter.setColorLight(R.color.vivid_violet_100)
                }
                 Companies.BEELINE -> {
                    nationAdapter.setColor(R.color.gorse_600)
                    nationAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })

        nationAdapter = NationAdapter(requireContext()) {}
        nationAdapter.setData(Constants.getNationItems())

        binding.rvNation.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvNation.adapter=nationAdapter
    }
    override fun getLayoutResId()=R.layout.fragment_nation

    override val vm: NationVM
        get() = NationVM()


}