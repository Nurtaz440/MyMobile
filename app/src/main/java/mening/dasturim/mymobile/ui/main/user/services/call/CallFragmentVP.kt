package mening.dasturim.mymobile.ui.main.user.services.call

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.call.internet.InternetXXXFragment
import mening.dasturim.mymobile.ui.main.user.services.call.ivr.IvrFragment
import mening.dasturim.mymobile.ui.main.user.services.call.lux.LuxFragment
import mening.dasturim.mymobile.ui.main.user.services.call.night.CallXFragment
import mening.dasturim.mymobile.ui.main.user.services.call.payment.PaymentFragment
import mening.dasturim.mymobile.ui.main.user.services.call.restart.RestartFragment

class CallFragmentVP (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return RestartFragment()
            1-> return InternetXXXFragment()
            2-> return CallXFragment()
            3-> return IvrFragment()
            4-> return LuxFragment()
            5-> return PaymentFragment()
        }

        return fragment
    }


}