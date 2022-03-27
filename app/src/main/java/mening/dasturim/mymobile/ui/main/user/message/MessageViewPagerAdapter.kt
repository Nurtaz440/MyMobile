package mening.dasturim.mymobile.ui.main.user.message

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import mening.dasturim.mymobile.ui.main.user.message.around.InternationalFragment
import mening.dasturim.mymobile.ui.main.user.message.daily.DailySmsFragment
import mening.dasturim.mymobile.ui.main.user.message.sms.SmsPacketsFragment

class MessageViewPagerAdapter(fragmentManager:FragmentManager,lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager,lifecycle){

    var list = listOf<String>()

    fun setData(itemList: List<String>){
        this.list=itemList
        notifyDataSetChanged()
    }
    override fun getItemCount()=list.size

    override fun createFragment(position: Int): Fragment {
        val fragment=Fragment()
        when(position){
            0-> return DailySmsFragment()
            1-> return SmsPacketsFragment()
            2-> return InternationalFragment()
        }
        return fragment
    }
}