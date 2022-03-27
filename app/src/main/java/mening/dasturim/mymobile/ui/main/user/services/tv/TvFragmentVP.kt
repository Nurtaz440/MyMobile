package mening.dasturim.mymobile.ui.main.user.services.tv

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.tv.dj.DjFragment
import mening.dasturim.mymobile.ui.main.user.services.tv.eight.EightFragment
import mening.dasturim.mymobile.ui.main.user.services.tv.friend.FriendFragment
import mening.dasturim.mymobile.ui.main.user.services.tv.itv.ItvFragment
import mening.dasturim.mymobile.ui.main.user.services.tv.news.NewFragment

class TvFragmentVP  (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return DjFragment()
            1-> return FriendFragment()
            2-> return EightFragment()
            3-> return ItvFragment()
            4-> return NewFragment()
        }

        return fragment
    }
}