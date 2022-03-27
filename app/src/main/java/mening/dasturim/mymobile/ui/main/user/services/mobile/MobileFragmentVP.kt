package mening.dasturim.mymobile.ui.main.user.services.mobile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.mymobile.ui.main.user.services.mobile.call.CallingFragment
import mening.dasturim.mymobile.ui.main.user.services.mobile.hide.HideFragment
import mening.dasturim.mymobile.ui.main.user.services.mobile.myservice.ServiceXFragment
import mening.dasturim.mymobile.ui.main.user.services.mobile.play.PlayFragment
import mening.dasturim.mymobile.ui.main.user.services.mobile.save.SaveXFragment
import mening.dasturim.mymobile.ui.main.user.services.mobile.solution.SolutionFragment

class MobileFragmentVP (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return ServiceXFragment()
            1-> return PlayFragment()
            2-> return mening.dasturim.mymobile.ui.main.user.services.mobile.service.ServiceXXFragment()
            3-> return SaveXFragment()
            4-> return HideFragment()
            5-> return SolutionFragment()
            6-> return CallingFragment()
        }

        return fragment
    }
}