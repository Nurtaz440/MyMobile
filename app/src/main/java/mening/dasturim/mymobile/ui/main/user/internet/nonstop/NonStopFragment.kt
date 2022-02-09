package mening.dasturim.mymobile.ui.main.user.internet.nonstop

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentNonStopBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class NonStopFragment : BaseFragment<FragmentNonStopBinding,NonStopVM>() {
    private lateinit var nonStopAdapter: NonStopAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    nonStopAdapter.setColor(R.color.deep_sky_blue_400)
                    nonStopAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    nonStopAdapter.setColor(R.color.alizarin_700)
                    nonStopAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    nonStopAdapter.setColor(R.color.vivid_violet_800)
                    nonStopAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    nonStopAdapter.setColor(R.color.gorse_600)
                    nonStopAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })

        nonStopAdapter = NonStopAdapter(requireContext()) {}
        nonStopAdapter.setData(Constants.getNotStopItems())

        binding.rvNonStop.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvNonStop.adapter=nonStopAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_non_stop

    override val vm: NonStopVM
        get() = ViewModelProvider(this).get(NonStopVM::class.java)


}