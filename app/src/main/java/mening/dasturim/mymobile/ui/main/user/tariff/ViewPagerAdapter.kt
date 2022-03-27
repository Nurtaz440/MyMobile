package mening.dasturim.mymobile.ui.main.user.tariff

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.tariff.best.BestFragment
import mening.dasturim.mymobile.ui.main.user.tariff.free.FreeFragment
import mening.dasturim.mymobile.ui.main.user.tariff.internet.InternetXFragment
import mening.dasturim.mymobile.ui.main.user.tariff.m2m.M2mFragment
import mening.dasturim.mymobile.ui.main.user.tariff.megaweek.MegaWeekFragment
import mening.dasturim.mymobile.ui.main.user.tariff.nation.NationFragment
import mening.dasturim.mymobile.ui.main.user.tariff.privilege.PrivilegeFragment
import mening.dasturim.mymobile.ui.main.user.tariff.units.UnitsFragment
import mening.dasturim.mymobile.ui.main.user.tariff.welcom.WelcomFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private var list = listOf<String>()


    fun setData(itemList: List<String>) {
        this.list = itemList
        notifyDataSetChanged()

    }

    override fun getItemCount() = list.size


    override fun createFragment(position: Int): Fragment {
        val fragment = Fragment()

        when(position){
            0-> return UnitsFragment()
            1-> return PrivilegeFragment()
            2-> return NationFragment()
            3-> return M2mFragment()
            4-> return InternetXFragment()
            5-> return WelcomFragment()
            6-> return BestFragment()
            7-> return MegaWeekFragment()
            8-> return FreeFragment()
        }
        return fragment
    }


}