package mening.dasturim.mymobile.data.module

import androidx.annotation.BoolRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DailyItems(
    @StringRes
    val name: Int,
    @DrawableRes
    val image: Int,
    @StringRes
    val abonent: Int,

    @StringRes
    val internet: Int,

    @BoolRes
    var expanded: Boolean =false
)