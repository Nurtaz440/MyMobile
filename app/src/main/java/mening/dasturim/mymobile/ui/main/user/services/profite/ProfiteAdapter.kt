package mening.dasturim.mymobile.ui.main.user.services.profite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.profite.resources.MbUzb
import mening.dasturim.mymobile.ui.main.user.services.profite.resources.minutsTomb.MinutsToMb

class ProfiteAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = Fragment()
        if (position == 0) {
            return MinutsToMb()
        } else if (position == 1) {
            return MbUzb()
        }
        return fragment
    }

}