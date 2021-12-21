package mening.dasturim.mymobile.ui.main.user.internet.nonstop

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
import mening.dasturim.mymobile.databinding.FragmentNonStopBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.rate.units.UNITSAdapter

class NonStopFragment : BaseFragment<FragmentNonStopBinding,NonStopVM>() {
    private lateinit var nonStopAdapter: NonStopAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        nonStopAdapter = NonStopAdapter {}
        nonStopAdapter.setData(Constants.getNotStopItems())

        binding.rvNonStop.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvNonStop.adapter=nonStopAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_non_stop

    override val vm: NonStopVM
        get() = ViewModelProvider(this).get(NonStopVM::class.java)


}