package mening.dasturim.mymobile.ui.main.user.services


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentServicesBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class ServicesFragment : BaseFragment<FragmentServicesBinding, ServicesVM>() {
    private lateinit var internetAdapter: ServiceAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp() {
        internetAdapter = ServiceAdapter {
            when(it){
                0 -> findNavController().navigate(R.id.profiteFragment)
                1 -> findNavController().navigate(R.id.limitFragment2)
                2 -> findNavController().navigate(R.id.callFragment)
                3 -> findNavController().navigate(R.id.ziyonetFragment)
                4 -> findNavController().navigate(R.id.mobileFragment)
                5 -> findNavController().navigate(R.id.testFragment)
                6 -> findNavController().navigate(R.id.tvFragment)

            }
        }
        CompanyState.getCompany().observe(this, Observer {
         when(it){
             Companies.UZMOBILE -> {
                 getUzmobile()
             }
               Companies.MOBIUZ -> {
                 getMobiUz()
             }
               Companies.UCELL -> {
                 getUcell()
             }
               Companies.BEELINE -> {
                 getBeeline()
             }

         }
        })

        binding.rvInternet.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvInternet.adapter = internetAdapter

    }
    fun getUzmobile(){
        internetAdapter.setData(Constants.getServiceItems())

    }
    fun getMobiUz(){
        internetAdapter.setData(Constants.getMobiUzServices())

    } fun getUcell(){
        internetAdapter.setData(Constants.getUcellServices())

    } fun getBeeline(){
        internetAdapter.setData(Constants.getBeelineServices())

    }

    override fun getLayoutResId() = R.layout.fragment_services

    override val vm: ServicesVM
        get() = ViewModelProvider(this).get(ServicesVM::class.java)


}