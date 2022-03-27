package mening.dasturim.mymobile.ui.main.user.services.family

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.family.family.FamilliyFragment
import mening.dasturim.mymobile.ui.main.user.services.family.kombo.KomboFragment
import mening.dasturim.mymobile.ui.main.user.services.family.penalty.PenaltyFragment
import mening.dasturim.mymobile.ui.main.user.services.family.support.SupportFragment
import mening.dasturim.mymobile.ui.main.user.services.family.ziyonet.ZiyoFragment

class ZiyonetFragmentVP(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return ZiyoFragment()
            1-> return SupportFragment()
            2-> return FamilliyFragment()
            3-> return PenaltyFragment()
            4-> return KomboFragment()
        }

        return fragment
    }


}