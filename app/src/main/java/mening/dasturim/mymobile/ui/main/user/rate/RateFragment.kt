package mening.dasturim.mymobile.ui.main.user.rate

import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.FragmentRateBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class RateFragment : BaseFragment<FragmentRateBinding, RateVM>() {
    private lateinit var fragmentAdapter: ViewPagerAdapter


    override fun onBound() {
        setUp()
    }

    fun setUp() {

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("UNITS"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Milliy"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Imtiyozli"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("M2M"))

        CompanyState.getCompany().observe(this, Observer {
            if (it != null){
                when(it){
                    Companies.UZMOBILE -> binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.deep_sky_blue_400))
                    Companies.MOBIUZ -> binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.alizarin_700))
                    Companies.UCELL -> binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.vivid_violet_800))
                    Companies.BEELINE -> binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.gorse_600))
                }

            }else{
                CompanyState.setCompany(Companies.UZMOBILE)
                prefs.company=Companies.UZMOBILE.name
            }

        })

        fragmentAdapter = ViewPagerAdapter(requireFragmentManager(), requireActivity().lifecycle)



        binding.viewPager.adapter = fragmentAdapter
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

    override fun getLayoutResId() = R.layout.fragment_rate

    override val vm: RateVM
        get() = ViewModelProvider(this).get(RateVM::class.java)


}