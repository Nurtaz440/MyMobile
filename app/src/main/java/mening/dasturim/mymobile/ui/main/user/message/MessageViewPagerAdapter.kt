package mening.dasturim.mymobile.ui.main.user.message

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import mening.dasturim.mymobile.ui.main.user.internet.paketlar.DailyFragment
import mening.dasturim.mymobile.ui.main.user.message.around.InternationalFragment
import mening.dasturim.mymobile.ui.main.user.message.daily.DailySmsFragment
import mening.dasturim.mymobile.ui.main.user.message.sms.SmsPacketsFragment

class MessageViewPagerAdapter(fragmentManager:FragmentManager,lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager,lifecycle){

    override fun getItemCount()=3
    override fun createFragment(position: Int): Fragment {
        val fragment=Fragment()
        if (position==0){
            return SmsPacketsFragment()
        }else if(position == 1){
            return DailySmsFragment()
        }else if (position == 2) {
            return InternationalFragment()
        }
        return fragment
    }
}