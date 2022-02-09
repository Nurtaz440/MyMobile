package mening.dasturim.mymobile.ui.main.user.message.around

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentInternationalBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
class InternationalFragment  : BaseFragment<FragmentInternationalBinding, InternationalVM>() {
    private lateinit var internetAdapter: InternationalAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    internetAdapter.setColor(R.color.deep_sky_blue_400)
                    internetAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    internetAdapter.setColor(R.color.alizarin_700)
                    internetAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    internetAdapter.setColor(R.color.vivid_violet_800)
                    internetAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    internetAdapter.setColor(R.color.gorse_600)
                    internetAdapter.setColorLight(R.color.gorse_100)
                }

            }
        })
        internetAdapter= InternationalAdapter(requireContext()) {  }

        internetAdapter.setData(Constants.getInterNonStopItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_international

    override val vm: InternationalVM
        get() = ViewModelProvider(this).get(InternationalVM::class.java)


}