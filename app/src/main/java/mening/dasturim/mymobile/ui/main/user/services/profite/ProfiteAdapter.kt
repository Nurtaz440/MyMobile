package mening.dasturim.mymobile.ui.main.user.services.profite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.profite.call.SecretFragment
import mening.dasturim.mymobile.ui.main.user.services.profite.intech.IntechFragment
import mening.dasturim.mymobile.ui.main.user.services.profite.kron.KronFragment
import mening.dasturim.mymobile.ui.main.user.services.profite.mbminuts.MbUzb
import mening.dasturim.mymobile.ui.main.user.services.profite.minutsmb.MinutsToMb
import mening.dasturim.mymobile.ui.main.user.services.profite.number.NumberFragment

class ProfiteAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return MbUzb()
            1-> return MinutsToMb()
            2-> return KronFragment()
            3-> return SecretFragment()
            4-> return IntechFragment()
            5-> return NumberFragment()
        }

        return fragment
    }


}