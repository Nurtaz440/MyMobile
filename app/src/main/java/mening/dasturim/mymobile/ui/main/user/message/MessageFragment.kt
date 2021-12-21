package mening.dasturim.mymobile.ui.main.user.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.FragmentMessageBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.rate.ViewPagerAdapter

class MessageFragment : BaseFragment<FragmentMessageBinding,MessageVM>() {
    private lateinit var messageViewPagerAdapter: MessageViewPagerAdapter
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("SMS-paketlar"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Kunlik SMS"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Xalqaro SMS"))


        messageViewPagerAdapter = MessageViewPagerAdapter(requireFragmentManager(), requireActivity().lifecycle)



        binding.viewPager.adapter = messageViewPagerAdapter
        binding.viewPager.offscreenPageLimit = 1

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab?.position!!
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



    override fun getLayoutResId()=R.layout.fragment_message

    override val vm: MessageVM
        get() = ViewModelProvider(this).get(MessageVM::class.java)

}