package mening.dasturim.mymobile.ui.main

import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.ActivityMainBinding
import mening.dasturim.mymobile.ui.base.BaseActivity
import mening.dasturim.mymobile.utils.ViewUtils

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onBound() {
        setUp()
    }

    fun setUp() {

        val navHost = supportFragmentManager.findFragmentById(R.id.partial_nav_controller)
        if (navHost != null) {
            navController = navHost.findNavController()
        }
        // bottomNavController=BottomNavController(binding,binding.partialBottomNavController,this,navController)

        binding.nvBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> navController.navigate(R.id.homeFragment)
                R.id.connect -> navController.navigate(R.id.connectFragment)
                R.id.setting -> navController.navigate(R.id.settingsFragment)
            }
            true
        }


        navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.connectFragment ||
                destination.id == R.id.settingsFragment
            ) {
                     ViewUtils.fadeIn(binding.nvBottom)
            } else {
                   ViewUtils.fadeOut(binding.nvBottom)
            }

            if (destination.id == R.id.homeFragment
            ) {
                ViewUtils.fadeOut(binding.appBarLayout)

            } else if (destination.id == R.id.settingsFragment ||
                destination.id == R.id.connectFragment
            ) {
                ViewUtils.fadeIn(binding.appBarLayout)
                ViewUtils.fadeIn(binding.tvInfoName)
                ViewUtils.fadeOut(binding.tvInfo)
                ViewUtils.fadeOut(binding.ivBackArrow)
            } else {
                ViewUtils.fadeIn(binding.appBarLayout)
                ViewUtils.fadeIn(binding.ivBackArrow)
                ViewUtils.fadeOut(binding.tvInfoName)
                ViewUtils.fadeIn(binding.tvInfo)
            }


            when (destination.id) {
                R.id.rateFragment -> binding.tvInfo.setText(R.string.tariflar)
                R.id.internetPocketsFragment -> binding.tvInfo.setText(R.string.internet_paketlar)
                R.id.minutesFragment -> binding.tvInfo.setText(R.string.daqiqalar)
                R.id.messageFragment -> binding.tvInfo.setText(R.string.sms_paketlar)
                R.id.USSDFragment -> binding.tvInfo.setText(R.string.ussd_kodlar)
                R.id.servicesFragment -> binding.tvInfo.setText(R.string.xizmatlar)
                R.id.connectFragment -> binding.tvInfoName.setText(R.string.account)
                R.id.settingsFragment -> binding.tvInfoName.setText(R.string.settings)
            }
        }
        binding.ivBackArrow.setOnClickListener { onBackPressed() }

    }


    override fun getLayoutResId() = R.layout.activity_main

    override val vm: MainVM by viewModels()

    override fun setStatusBarBackgroundHeight(statusBarBackground: View) {

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}