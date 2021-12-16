package mening.dasturim.mymobile.ui.main.user.rate

import android.view.LayoutInflater
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.FragmentRateBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.rate.m2m.M2MFragment
import mening.dasturim.mymobile.ui.main.user.rate.nation.NationFragment
import mening.dasturim.mymobile.ui.main.user.rate.privilege.PrivilegeFragment
import mening.dasturim.mymobile.ui.main.user.rate.units.UNITSFragment

class RateFragment : BaseFragment<FragmentRateBinding, RateVM>() {
    private lateinit var fragmentAdapter: ViewPagerAdapter

    override fun onBound() {
        setUp()
    }

    fun setUp() {


        fragmentAdapter=ViewPagerAdapter(requireFragmentManager())

        fragmentAdapter.addFragment(UNITSFragment(),"UNITS")
        fragmentAdapter.addFragment(NationFragment(),"Milliy")
        fragmentAdapter.addFragment(PrivilegeFragment(),"Imtiyozlar")
        fragmentAdapter.addFragment(M2MFragment(),"M2M")


        binding.viewPager.adapter=fragmentAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        for(i in 0..binding.tabLayout.tabCount step 1){
            val tv : TextView= LayoutInflater.from(activity)
                .inflate(R.layout.item_viewpager,null) as TextView

            binding.tabLayout.getTabAt(i)?.setCustomView(tv)
        }

    }

    override fun getLayoutResId() = R.layout.fragment_rate

    override val vm: RateVM
        get() = ViewModelProvider(this).get(RateVM::class.java)


}