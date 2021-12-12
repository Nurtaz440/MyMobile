package mening.dasturim.mymobile.ui.main.user.home

import androidx.lifecycle.ViewModelProvider
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.FragmentHomeBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.utils.ViewUtils

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>() {
    override fun onBound() {
        setUp()
    }

    fun setUp() {

        binding.cvUzmobile.setOnClickListener {
            ViewUtils.fadeIn(binding.cvItem)
            ViewUtils.fadeOut(binding.cvItem2)
            ViewUtils.fadeOut(binding.cvItem3)
            ViewUtils.fadeOut(binding.cvItem4)

        }
          binding.cvMobiuz.setOnClickListener {
              ViewUtils.fadeIn(binding.cvItem2)
              ViewUtils.fadeOut(binding.cvItem)
              ViewUtils.fadeOut(binding.cvItem3)
              ViewUtils.fadeOut(binding.cvItem4)
        }
          binding.cvUcell.setOnClickListener {
              ViewUtils.fadeIn(binding.cvItem3)
              ViewUtils.fadeOut(binding.cvItem2)
              ViewUtils.fadeOut(binding.cvItem)
              ViewUtils.fadeOut(binding.cvItem4)
        }
          binding.cvBeeline.setOnClickListener {
              ViewUtils.fadeIn(binding.cvItem4)
              ViewUtils.fadeOut(binding.cvItem2)
              ViewUtils.fadeOut(binding.cvItem3)
              ViewUtils.fadeOut(binding.cvItem)
        }

    }


    override fun getLayoutResId() = R.layout.fragment_home
    override val vm: HomeVM
        get() = ViewModelProvider(this).get(HomeVM::class.java)


}