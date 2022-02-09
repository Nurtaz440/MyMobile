package mening.dasturim.mymobile.ui.main.user.rate

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.rate.m2m.M2mFragment
import mening.dasturim.mymobile.ui.main.user.rate.nation.NationFragment
import mening.dasturim.mymobile.ui.main.user.rate.privilege.PrivilegeFragment
import mening.dasturim.mymobile.ui.main.user.rate.units.UnitsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {

       return 4
    }

    override fun createFragment(position: Int): Fragment {
        val fragment=Fragment()
        if (position==0){
            return UnitsFragment()
        }else if (position ==1){
            return NationFragment()
        }else if (position ==2){
            return PrivilegeFragment()
        }else if (position ==3) {
            return M2mFragment()
        }
        return fragment
    }



}