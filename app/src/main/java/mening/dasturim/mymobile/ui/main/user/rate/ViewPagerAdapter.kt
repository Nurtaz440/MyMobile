package mening.dasturim.mymobile.ui.main.user.rate

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragmentList=ArrayList<Fragment>()
    private val fragmentTitle= ArrayList<String>()



    override fun getCount(): Int=fragmentList.size

    override fun getItem(position: Int): Fragment =fragmentList[position]
    override fun getPageTitle(position: Int): CharSequence=fragmentTitle[position]

    fun addFragment(fm:Fragment,title:String){
        fragmentList.add(fm)
        fragmentTitle.add(title)
    }
}