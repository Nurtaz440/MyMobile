package mening.dasturim.mymobile.ui.main.user.rate.privilege

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentPrivilegeBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class PrivilegeFragment : BaseFragment<FragmentPrivilegeBinding,PrivilegeVM>() {
    private  lateinit var privilegeAdapter: PrivilegeAdapter
    override fun onBound() {

        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    privilegeAdapter.setColorIcon(R.color.deep_sky_blue_400)
                    privilegeAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    privilegeAdapter.setColorIcon(R.color.alizarin_700)
                    privilegeAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    privilegeAdapter.setColorIcon(R.color.vivid_violet_800)
                    privilegeAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    privilegeAdapter.setColorIcon(R.color.gorse_600)
                    privilegeAdapter.setColorLight(R.color.gorse_100)
                }
            }
        })
        privilegeAdapter = PrivilegeAdapter(requireContext()) {}
        privilegeAdapter.setData(Constants.getPrivilegeItems())

        binding.rvPrivilege.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvPrivilege.adapter=privilegeAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_privilege

    override val vm: PrivilegeVM
        get() = ViewModelProvider(this).get(PrivilegeVM::class.java)


}