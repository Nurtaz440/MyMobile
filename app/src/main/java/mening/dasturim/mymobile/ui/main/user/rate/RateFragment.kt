package mening.dasturim.mymobile.ui.main.user.rate

import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.FragmentRateBinding
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
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Imtiyozli"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("M2M"))


        fragmentAdapter = ViewPagerAdapter(requireFragmentManager(), requireActivity().lifecycle)


//        fragmentAdapter.addFragment(UNITSFragment(),"UNITS")
//        fragmentAdapter.addFragment(NationFragment(),"Milliy")
//        fragmentAdapter.addFragment(PrivilegeFragment(),"Imtiyozlar")
//        fragmentAdapter.addFragment(M2MFragment(),"M2M")


        binding.viewPager.adapter = fragmentAdapter
        binding.viewPager.offscreenPageLimit = 1

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.setCurrentItem(tab?.position!!)
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


        //  binding.tabLayout.setupWithViewPager(binding.viewPager)
//
//        TabLayoutMediator(binding.tabLayout,binding.viewPager){
//            tab,position->
////            when(position){
////                0->{
////                    tab.setText(R.string.units)
////                }
////                 1->{
////                    tab.setText(R.string.milliy)
////                }
////                 2->{
////                    tab.setText(R.string.imtiyozlar)
////                }
////                 3->{
////                    tab.setText(R.string.m2m)
////                }
//
//
//            tab.text = fragmentAdapter.fragmentTitle[position]
//        }.attach()
//
//        for(i in 0..binding.tabLayout.tabCount step 1){
//            val tv : TextView= LayoutInflater.from(activity)
//                .inflate(R.layout.item_viewpager,null) as TextView
//            binding.tabLayout.getTabAt(i)?.customView = tv
//        }
//
    }

    override fun getLayoutResId() = R.layout.fragment_rate

    override val vm: RateVM
        get() = ViewModelProvider(this).get(RateVM::class.java)


}