package mening.dasturim.mymobile.ui.main

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.ActivityMainBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseActivity
import mening.dasturim.mymobile.utils.ViewUtils

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onBound() {
        setUp()
    }

    @SuppressLint("LogConditional")
    fun setUp() {
        val companie = prefs.company
    //    Log.d("Companie observe",prefs.company!!)
        if (companie != null) {
            when(companie){
                Companies.UZMOBILE.name -> CompanyState.setCompany(Companies.UZMOBILE)
                Companies.MOBIUZ.name -> CompanyState.setCompany(Companies.MOBIUZ)
                Companies.UCELL.name -> CompanyState.setCompany(Companies.UCELL)
                Companies.BEELINE.name -> CompanyState.setCompany(Companies.BEELINE)
            }
        } else {
            CompanyState.setCompany(Companies.UZMOBILE)
            prefs.company=Companies.UZMOBILE.name
        }

       //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        val navHost = supportFragmentManager.findFragmentById(R.id.partial_nav_controller)
        if (navHost != null) {
            navController = navHost.findNavController()
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.connectFragment ||
                destination.id == R.id.settingsFragment
            ) {
                ViewUtils.fadeIn(binding.nvBottomBlue)
            } else {
                ViewUtils.fadeOut(binding.nvBottomBlue)
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
                R.id.minutsPocket -> binding.tvInfo.setText(R.string.daqiqalar)
                R.id.messageFragment -> binding.tvInfo.setText(R.string.sms_paketlar)
                R.id.USSDFragment -> binding.tvInfo.setText(R.string.ussd_kodlar)
                R.id.servicesFragment -> binding.tvInfo.setText(R.string.xizmatlar)
                R.id.connectFragment -> binding.tvInfoName.setText(R.string.account)
                R.id.settingsFragment -> binding.tvInfoName.setText(R.string.settings)
                R.id.profiteFragment -> binding.tvInfo.setText(R.string.profite)
            }
        }

        binding.nvBottomBlue.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)

                }
                R.id.connect -> {
                    navController.navigate(R.id.connectFragment)
                }
                R.id.setting -> {
                    navController.navigate(R.id.settingsFragment)

                }
            }
            true
        }


        CompanyState.getCompany().observe(this, Observer {
            when (it) {
                Companies.UZMOBILE -> {
                    companyUzmobile()

                }
                Companies.MOBIUZ -> {
                    companyMobiuz()
                }
                Companies.UCELL -> {
                    companyUcell()
                }
                Companies.BEELINE -> {
                    companyBeeline()
                }

            }
        })

        binding.ivBackArrow.setOnClickListener { onBackPressed() }

    }

    fun companyUzmobile() {
        binding.nvBottomBlue.itemIconTintList =
            ContextCompat.getColorStateList(this, R.color.deep_sky_blue_400)
    }

    fun companyMobiuz() {
        binding.nvBottomBlue.itemIconTintList =
            ContextCompat.getColorStateList(this, R.color.alizarin_700)
    }

    fun companyUcell() {
        binding.nvBottomBlue.itemIconTintList =
            ContextCompat.getColorStateList(this, R.color.vivid_violet_800)
    }

    fun companyBeeline() {
        binding.nvBottomBlue.itemIconTintList =
            ContextCompat.getColorStateList(this, R.color.gorse_600)
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