package mening.dasturim.mymobile.ui.main.user.minuts

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.minuts.call.MinutesFragment
import mening.dasturim.mymobile.ui.main.user.minuts.network.NetworkFragment
import mening.dasturim.mymobile.ui.main.user.minuts.speak.SpeakFragment

class MinutsPocketVP(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return MinutesFragment()
            1-> return SpeakFragment()
            2-> return NetworkFragment()
        }

        return fragment
    }


}