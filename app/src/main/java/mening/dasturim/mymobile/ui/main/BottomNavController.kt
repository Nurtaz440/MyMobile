package mening.dasturim.mymobile.ui.main

import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.BottomNavControllerBinding
import mening.dasturim.mymobile.databinding.FragmentHomeBinding
import mening.dasturim.mymobile.ui.main.user.home.HomeFragment

class BottomNavController(
    private val bindingFragment: FragmentHomeBinding,
    private val binding: BottomNavControllerBinding,
    private val activity: HomeFragment,
    private val navController: NavController
) {
    private var oldClickedItemPos = 0
    private var lastClickedItemPos = 0
    private lateinit var navOptions: NavOptions
    private var lastBackClickItem = 0L

    init {
        controlBottomNav()
    }

    private fun controlBottomNav() {

        binding.apply {
            cl1.setOnClickListener {
                lastClickedItemPos = 0
                handleClick()
            }
            cl2.setOnClickListener {
                lastClickedItemPos = 1
                handleClick()
            }
            cl3.setOnClickListener {
                lastClickedItemPos = 2
                handleClick()
            }
            cl4.setOnClickListener {
                lastClickedItemPos = 3
                handleClick()
            }
        }
    }

    private fun handleClick() {
        // makeDefaultItem()
        highLightItem()
    }
//
//    private fun makeDefaultItem() {
//        binding.apply {
//            when (oldClickedItemPos) {
//                0 -> ViewUtils.fadeOut()
//                1 -> ViewUtils.fadeOut()
//                2 -> ViewUtils.fadeOut()
//                3 -> ViewUtils.fadeOut()
//            }
//        }
//    }

    private fun highLightItem() {
        binding.apply {
            when (lastClickedItemPos) {
                0 -> {
                    navOptions = NavOptions.Builder()
                        .setLaunchSingleTop(true)
                        .setPopUpTo(R.id.homeFragment, true)
                        .build()
                    binding.ivBlueHome.setColorFilter(R.color.deep_sky_blue_400)
                    binding.ivAccount.setColorFilter(R.color.grey_500)
                    binding.ivNotification.setColorFilter(R.color.grey_500)
                    binding.ivSettings.setColorFilter(R.color.grey_500)
//                    ViewUtils.fadeIn(
//                        ContextCompat.getDrawable(activity, R.color.deep_sky_blue_400),
//                        200
//                    )
                    navController.navigate(R.id.homeFragment, bundleOf(), navOptions)
                    return@apply
                }

                1 -> {
                    navOptions = NavOptions.Builder()
                        .setLaunchSingleTop(true)
                        .build()
//                    ViewUtils.fadeIn(
//                        ContextCompat.getDrawable(activity, R.color.deep_sky_blue_400),
//                        200
//                    )
                    navController.navigate(R.id.accountFragment, bundleOf(), navOptions)
                    binding.ivBlueHome.setColorFilter(R.color.grey_500)
                    binding.ivAccount.setColorFilter(R.color.deep_sky_blue_400)
                    binding.ivNotification.setColorFilter(R.color.grey_500)
                    binding.ivSettings.setColorFilter(R.color.grey_500)
                    return@apply
                }
                2 -> {
                    navOptions = NavOptions.Builder()
                        .setLaunchSingleTop(true)
                        .build()
//                    ViewUtils.fadeIn(
//                        ContextCompat.getDrawable(activity, R.color.deep_sky_blue_400),
//                        200
//                    )
                    navController.navigate(R.id.notificationFragment, bundleOf(), navOptions)
                    binding.ivBlueHome.setColorFilter(R.color.grey_500)
                    binding.ivAccount.setColorFilter(R.color.grey_500)
                    binding.ivNotification.setColorFilter(R.color.deep_sky_blue_400)
                    binding.ivSettings.setColorFilter(R.color.grey_500)
                    return@apply
                }
                3 -> {
                    navOptions = NavOptions.Builder()
                        .setLaunchSingleTop(true)
                        .build()
//                    ViewUtils.fadeIn(
//                        ContextCompat.getDrawable(activity, R.color.deep_sky_blue_400),
//                        200
//                    )
                    binding.ivBlueHome.setColorFilter(R.color.grey_500)
                    binding.ivAccount.setColorFilter(R.color.grey_500)
                    binding.ivNotification.setColorFilter(R.color.grey_500)
                    binding.ivSettings.setColorFilter(R.color.deep_sky_blue_400)
                    navController.navigate(R.id.settingsFragment, bundleOf(), navOptions)
                    return@apply
                }
            }
        }
        oldClickedItemPos = lastClickedItemPos

    }

    fun onBackPressed(): Boolean {
        val currentDest = navController.currentDestination?.id
        if (currentDest == R.id.homeFragment) {

            Log.d("------------", "onBackPressed Called")
            val currentTime = System.currentTimeMillis()

            if (lastClickedItemPos + 2000 > currentTime) {
                activity.onDestroyView()
            }else{
        //        activity.showToast("Ikki marta bo'sing")
                lastBackClickItem = currentTime
            }
            return true
        }
        return false
    }
}