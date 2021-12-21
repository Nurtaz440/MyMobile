package mening.dasturim.mymobile.ui.main.user.internet.tasix

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
import mening.dasturim.mymobile.databinding.FragmentTasixBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.internet.internet.InternetAdapter

class TasixFragment : BaseFragment<FragmentTasixBinding,TasixVM>() {
    private lateinit var tasixAdapter: TasixAdapter
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        tasixAdapter= TasixAdapter {  }

        tasixAdapter.setData(Constants.getTasixItems())
        binding.rvTasix.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvTasix.adapter=tasixAdapter
    }

    override fun getLayoutResId()=R.layout.fragment_tasix

    override val vm: TasixVM
        get() = ViewModelProvider(this).get(TasixVM::class.java)


}