package mening.dasturim.mymobile.ui.main.user.internet

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.internet.internet.InternetFragment
import mening.dasturim.mymobile.ui.main.user.internet.internetNonstop.InterNonstop
import mening.dasturim.mymobile.ui.main.user.internet.nonstop.NonStopFragment
import mening.dasturim.mymobile.ui.main.user.internet.paketlar.DailyFragment
import mening.dasturim.mymobile.ui.main.user.internet.tasix.TasixFragment

class InternetViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager,lifecycle) {


    override fun getItemCount()=5

    override fun createFragment(position: Int): Fragment {
        val fragment=Fragment()
        if (position==0){
            return NonStopFragment()
        }else if(position == 1){
            return DailyFragment()
        }else if (position == 2){
            return InterNonstop()
        }else if (position== 3){
            return InternetFragment()
        }else if (position==4){
            return TasixFragment()
        }
        return fragment
    }
}