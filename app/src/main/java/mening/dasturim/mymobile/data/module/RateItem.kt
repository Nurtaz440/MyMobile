package mening.dasturim.mymobile.data.module

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RateItem(
    @StringRes
    val name : Int,
    @DrawableRes
    val image:Int
)