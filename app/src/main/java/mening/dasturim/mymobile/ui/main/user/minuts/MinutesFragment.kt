package mening.dasturim.mymobile.ui.main.user.minuts


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentMinutsBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class MinutesFragment  : BaseFragment<FragmentMinutsBinding, MinutesVM>() {
    private lateinit var minutesAdapter: MinutesAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    minutesAdapter.setColor(R.color.deep_sky_blue_400)
                    minutesAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    minutesAdapter.setColor(R.color.alizarin_700)
                    minutesAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    minutesAdapter.setColor(R.color.vivid_violet_800)
                    minutesAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    minutesAdapter.setColor(R.color.gorse_600)
                    minutesAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })

        minutesAdapter= MinutesAdapter(requireContext()) {  }

        minutesAdapter.setData(Constants.getMinutesItems())
        binding.rvMinutes.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvMinutes.adapter=minutesAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_minuts

    override val vm: MinutesVM
        get() = ViewModelProvider(this).get(MinutesVM::class.java)


}