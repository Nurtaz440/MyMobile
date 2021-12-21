package mening.dasturim.mymobile.ui.main.user.minuts


import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentMinutsBinding
import mening.dasturim.mymobile.ui.base.BaseFragment

class MinutesFragment  : BaseFragment<FragmentMinutsBinding, MinutesVM>() {
    private lateinit var minutesAdapter: MinutesAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        minutesAdapter= MinutesAdapter {  }

        minutesAdapter.setData(Constants.getMinutesItems())
        binding.rvMinutes.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvMinutes.adapter=minutesAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_minuts

    override val vm: MinutesVM
        get() = ViewModelProvider(this).get(MinutesVM::class.java)


}