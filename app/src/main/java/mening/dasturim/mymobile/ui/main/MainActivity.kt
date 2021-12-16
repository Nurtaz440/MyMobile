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
            if (destination.id == R.id.homeFragment
            ) {
                ViewUtils.fadeOut(binding.appBarLayout)

            } else {
                ViewUtils.fadeIn(binding.appBarLayout)
            }

            when (destination.id) {
                R.id.rateFragment -> binding.tvInfo.setText(R.string.tariflar)
                R.id.internetPocketsFragment -> binding.tvInfo.setText(R.string.internet_paketlar)
                R.id.minutesFragment -> binding.tvInfo.setText(R.string.daqiqalar)
                R.id.messageFragment -> binding.tvInfo.setText(R.string.sms_paketlar)
                R.id.USSDFragment -> binding.tvInfo.setText(R.string.ussd_kodlar)
                R.id.servicesFragment -> binding.tvInfo.setText(R.string.xizmatlar)
                R.id.accountFragment -> binding.tvInfo.setText(R.string.account)
                R.id.notificationFragment -> binding.tvInfo.setText(R.string.notify)
                R.id.settingsFragment -> binding.tvInfo.setText(R.string.settings)
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