package mening.dasturim.mymobile.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import mening.dasturim.mymobile.databinding.BottomNavControllerBinding
import mening.dasturim.mymobile.databinding.FragmentHomeBinding
import mening.dasturim.mymobile.ui.main.user.home.HomeFragment

class BottomNavController(
    private val bindingFragment: FragmentHomeBinding,
    private val binding: BottomNavControllerBinding,
    private val activity: AppCompatActivity,
    private val navController: NavController
) {

}