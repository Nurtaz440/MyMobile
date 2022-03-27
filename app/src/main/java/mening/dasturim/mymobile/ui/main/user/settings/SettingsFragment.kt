package mening.dasturim.mymobile.ui.main.user.settings

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentServicesBinding
import mening.dasturim.mymobile.ui.base.BaseFragment

class SettingsFragment : BaseFragment<FragmentServicesBinding, SettingsFragmentVM>() {
    private lateinit var internetAdapter: SettingsAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= SettingsAdapter {

        }


        internetAdapter.setData(Constants.getSettingsItems())
        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_services

    override val vm: SettingsFragmentVM
        get() = ViewModelProvider(this).get(SettingsFragmentVM::class.java)


}