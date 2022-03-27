package mening.dasturim.mymobile.ui.main.user.internet

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.internet.byhours.HoursFragment
import mening.dasturim.mymobile.ui.main.user.internet.internet.InternetFragment
import mening.dasturim.mymobile.ui.main.user.internet.internetNonstop.InterNonstop
import mening.dasturim.mymobile.ui.main.user.internet.max.MaxFragment
import mening.dasturim.mymobile.ui.main.user.internet.megabayt.MegabaytFragment
import mening.dasturim.mymobile.ui.main.user.internet.megaboom.MegaBoomFragment
import mening.dasturim.mymobile.ui.main.user.internet.monthly.MonthlFragment
import mening.dasturim.mymobile.ui.main.user.internet.night.NightFragment
import mening.dasturim.mymobile.ui.main.user.internet.nightinternet.NightXXFragment
import mening.dasturim.mymobile.ui.main.user.internet.nonstop.NonStopFragment
import mening.dasturim.mymobile.ui.main.user.internet.order.OrderFragment
import mening.dasturim.mymobile.ui.main.user.internet.paketlar.DailyFragment
import mening.dasturim.mymobile.ui.main.user.internet.tasix.TasixFragment
import mening.dasturim.mymobile.ui.main.user.internet.traffik.TrafficFragment
import mening.dasturim.mymobile.ui.main.user.internet.underground.UnderFragment

class InternetViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager,lifecycle) {
    var list = listOf<String>()

    fun setData(itemList: List<String>){
        this.list=itemList
        notifyDataSetChanged()
    }
    override fun getItemCount()=list.size

    override fun createFragment(position: Int): Fragment {
        val fragment=Fragment()
        when(position){
            0-> return InternetFragment()
            1-> return InterNonstop()
            2-> return NonStopFragment()
            3-> return DailyFragment()
            4-> return TasixFragment()
            5-> return MegaBoomFragment()
            6-> return MaxFragment()
            7-> return UnderFragment()
            8-> return MonthlFragment()
            9-> return HoursFragment()
            10-> return TrafficFragment()
            11-> return NightXFragment()
            12-> return NightXXFragment()
            13-> return NightFragment()
            14-> return MegabaytFragment()
            15-> return OrderFragment()
        }
        return fragment
    }
}