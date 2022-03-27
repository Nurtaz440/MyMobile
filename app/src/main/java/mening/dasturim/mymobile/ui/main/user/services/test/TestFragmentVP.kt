package mening.dasturim.mymobile.ui.main.user.services.test

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.test.behamer.BehamerFrgament
import mening.dasturim.mymobile.ui.main.user.services.test.close.CloseFragment
import mening.dasturim.mymobile.ui.main.user.services.test.dixanet.DixanetFragment
import mening.dasturim.mymobile.ui.main.user.services.test.save.SaveFragment
import mening.dasturim.mymobile.ui.main.user.services.test.sms.SurkhandariyoFragment
import mening.dasturim.mymobile.ui.main.user.services.test.test.GovermentFragment
import mening.dasturim.mymobile.ui.main.user.services.test.vas.VasFragment

class TestFragmentVP (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return SurkhandariyoFragment()
            1-> return VasFragment()
            2-> return CloseFragment()
            3-> return BehamerFrgament()
            4-> return SaveFragment()
            5-> return GovermentFragment()
            6-> return DixanetFragment()
        }

        return fragment
    }
}