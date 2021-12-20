package mening.dasturim.mymobile.ui.main.user.rate.units

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentUNITSBinding
import mening.dasturim.mymobile.ui.base.BaseFragment

class UNITSFragment : BaseFragment<FragmentUNITSBinding, UNITSFragmentVM>() {
    private lateinit var rateAdapter: UNITSAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp() {
        rateAdapter = UNITSAdapter {}
        rateAdapter.setData(Constants.getRateItems())

        binding.rvUnits.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvUnits.adapter=rateAdapter
    }

    override fun getLayoutResId() = R.layout.fragment_u_n_i_t_s

    override val vm: UNITSFragmentVM
        get() = ViewModelProvider(this).get(UNITSFragmentVM::class.java)


}