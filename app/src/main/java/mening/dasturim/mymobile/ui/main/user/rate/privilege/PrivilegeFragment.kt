package mening.dasturim.mymobile.ui.main.user.rate.privilege

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentPrivilegeBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.rate.nation.NationAdapter

class PrivilegeFragment : BaseFragment<FragmentPrivilegeBinding,PrivilegeVM>() {
    private  lateinit var privilegeAdapter: PrivilegeAdapter
    override fun onBound() {

        setUp()
    }

    fun setUp(){
        privilegeAdapter = PrivilegeAdapter {}
        privilegeAdapter.setData(Constants.getPrivilegeItems())

        binding.rvPrivilege.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvPrivilege.adapter=privilegeAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_privilege

    override val vm: PrivilegeVM
        get() = ViewModelProvider(this).get(PrivilegeVM::class.java)


}