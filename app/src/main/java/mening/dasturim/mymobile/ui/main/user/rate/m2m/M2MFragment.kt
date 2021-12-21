package mening.dasturim.mymobile.ui.main.user.rate.m2m


import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentM2MBinding
import mening.dasturim.mymobile.ui.base.BaseFragment

class M2MFragment : BaseFragment<FragmentM2MBinding,M2mVM>() {
    private lateinit var m2mAdapter: M2MAdapter
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        m2mAdapter = M2MAdapter {}
        m2mAdapter.setData(Constants.getM2MItems())

        binding.rvM2m.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvM2m.adapter=m2mAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_m2_m
    override val vm: M2mVM
        get() = ViewModelProvider(this).get(M2mVM::class.java)


}