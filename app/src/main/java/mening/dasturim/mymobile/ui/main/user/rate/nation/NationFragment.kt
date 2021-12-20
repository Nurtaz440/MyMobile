package mening.dasturim.mymobile.ui.main.user.rate.nation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentNationBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.rate.units.UNITSAdapter

class NationFragment : BaseFragment<FragmentNationBinding,NationVM>() {
    private lateinit var nationAdapter: NationAdapter

    override fun onBound() {
        setUp()
    }

    fun setUp(){
        nationAdapter = NationAdapter {}
        nationAdapter.setData(Constants.getNationItems())

        binding.rvNation.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvNation.adapter=nationAdapter
    }
    override fun getLayoutResId()=R.layout.fragment_nation

    override val vm: NationVM
        get() = NationVM()


}