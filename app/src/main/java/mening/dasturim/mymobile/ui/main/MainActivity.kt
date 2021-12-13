package mening.dasturim.mymobile.ui.main

import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.ActivityMainBinding
import mening.dasturim.mymobile.ui.base.BaseActivity
import mening.dasturim.mymobile.utils.ViewUtils

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavController: BottomNavController
    private lateinit var navController: NavController

    override fun onBound() {
        setUp()
    }

    fun setUp() {
        val navHost = supportFragmentManager.findFragmentById(R.id.partial_nav_controller)
        if (navHost != null) {
            navController = navHost.findNavController()
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.rateFragment ||
                destination.id == R.id.internetPocketsFragment ||
                destination.id == R.id.messageFragment ||
                destination.id == R.id.servicesFragment ||
                destination.id == R.id.USSDFragment ||
                destination.id == R.id.minutesFragment
            ) {
                ViewUtils.fadeIn(binding.appBarLayout)

            } else {
                ViewUtils.fadeOut(binding.appBarLayout)
            }

            when (destination.id) {
                R.id.rateFragment->binding.tvInfo.setText(R.string.tariflar)
                R.id.internetPocketsFragment->binding.tvInfo.setText(R.string.internet_paketlar)
                R.id.minutesFragment->binding.tvInfo.setText(R.string.daqiqalar)
                R.id.messageFragment->binding.tvInfo.setText(R.string.sms_paketlar)
                R.id.USSDFragment->binding.tvInfo.setText(R.string.ussd_kodlar)
                R.id.servicesFragment->binding.tvInfo.setText(R.string.xizmatlar)
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

//        if (navController.currentDestination!!.id == R.id.rateFragment ||
//            navController.currentDestination!!.id== R.id.internetPocketsFragment ||
//            navController.currentDestination!!.id == R.id.messageFragment ||
//            navController.currentDestination!!.id == R.id.servicesFragment ||
//            navController.currentDestination!!.id == R.id.USSDFragment ||
//            navController.currentDestination!!.id == R.id.minutesFragment
//        ) {
//            navController.popBackStack(R.id.homeFragment,false)
//        }
        super.onBackPressed()

    }
}