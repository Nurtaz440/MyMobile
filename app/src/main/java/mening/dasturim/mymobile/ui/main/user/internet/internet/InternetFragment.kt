package mening.dasturim.mymobile.ui.main.user.internet.internet

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
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.ui.base.BaseFragment

class InternetFragment : BaseFragment<FragmentInternetBinding,InternetVM>() {
    private lateinit var internetAdapter: InternetAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        internetAdapter= InternetAdapter {  }


        internetAdapter.setData(Constants.getInternetPocketsItems())
        binding.rvInternet.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

    }

    override fun getLayoutResId()=R.layout.fragment_internet

    override val vm: InternetVM
        get() = ViewModelProvider(this).get(InternetVM::class.java)


}