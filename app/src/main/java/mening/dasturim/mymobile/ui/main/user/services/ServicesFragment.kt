package mening.dasturim.mymobile.ui.main.user.services


import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentServicesBinding
import mening.dasturim.mymobile.ui.base.BaseFragment

class ServicesFragment  : BaseFragment<FragmentServicesBinding, ServicesVM>() {
    private lateinit var internetAdapter: ServiceAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= ServiceAdapter {  }


        internetAdapter.setData(Constants.getServiceItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_services

    override val vm: ServicesVM
        get() = ViewModelProvider(this).get(ServicesVM::class.java)


}