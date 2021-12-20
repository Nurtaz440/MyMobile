package mening.dasturim.mymobile.data.module

import androidx.annotation.BoolRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RateItem(
    @StringRes
    val name: Int,
    @DrawableRes
    val image: Int,
    @StringRes
    val abonent: Int,

    @StringRes
    val limit: Int,

    @StringRes
    val internet: Int,

    @StringRes
    val call: Int,

    @StringRes
    val message: Int,

    @BoolRes
    var expanded: Boolean =false
)