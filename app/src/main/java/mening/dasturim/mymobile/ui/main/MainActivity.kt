package mening.dasturim.mymobile.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.ActivityMainBinding
import mening.dasturim.mymobile.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainVM>() {
    override fun onBound() {
      setUp()
    }

    fun setUp(){

    }


    override fun getLayoutResId()=R.layout.activity_main

    override val vm: MainVM by viewModels()

    override fun setStatusBarBackgroundHeight(statusBarBackground: View) {

    }

}