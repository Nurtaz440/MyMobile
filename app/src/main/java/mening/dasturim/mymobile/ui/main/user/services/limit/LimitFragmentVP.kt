package mening.dasturim.mymobile.ui.main.user.services.limit

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.limit.balans.BalansFragment
import mening.dasturim.mymobile.ui.main.user.services.limit.limit.LimitXFragment
import mening.dasturim.mymobile.ui.main.user.services.limit.mediabay.MediabayFragment
import mening.dasturim.mymobile.ui.main.user.services.limit.physical.PhysicalFragment
import mening.dasturim.mymobile.ui.main.user.services.limit.synerika.SynerikaFragment

class LimitFragmentVP (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return LimitXFragment()
            1-> return MediabayFragment()
            2-> return BalansFragment()
            3-> return PhysicalFragment()
            4-> return SynerikaFragment()
        }

        return fragment
    }


}