package mening.dasturim.mymobile.ui.main.user.internet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.databinding.FragmentInternetPocketsBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.internet.internet.InternetVM

class InternetPocketsFragment : BaseFragment<FragmentInternetPocketsBinding,InternetPocketsVM>() {
    private lateinit var internetViewPagerAdapter:InternetViewPagerAdapter

    override fun onBound() {
        setUp()
    }

    fun setUp(){

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Kunlik non stop"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Kunlik paketlar"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Internet non stop"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Internet paketlar"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAS-IX"))

        internetViewPagerAdapter= InternetViewPagerAdapter(requireFragmentManager(),requireActivity().lifecycle)
        binding.viewPager.adapter=internetViewPagerAdapter
        binding.viewPager.offscreenPageLimit=1

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem=tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

    }
    override fun getLayoutResId()=R.layout.fragment_internet_pockets

    override val vm: InternetPocketsVM
        get() = ViewModelProvider(this).get(InternetPocketsVM::class.java)


}