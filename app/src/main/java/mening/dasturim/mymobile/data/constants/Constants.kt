package mening.dasturim.mymobile.data.constants

import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.local.PrefsHelper
import mening.dasturim.mymobile.data.module.RateItem

object Constants {
    lateinit var prefs:PrefsHelper

    var language= ""

    const val LANGUAGE_RUSSIAN: String = "ru"
    const val LANGUAGE_UZBEK: String = "uz"
    const val LANGUAGE_ENGLISH: String = "en"

    const val CALL_CENTER_NUMBER_UZMOBILE="1084"
    const val CALL_CENTER_NUMBER_MOBIEUZ="0870"
    const val CALL_CENTER_NUMBER_UCELL="8123"
    const val CALL_CENTER_NUMBER_BEELINE="0639"

    fun getRateItems():ArrayList<RateItem>{
        return arrayListOf(
            RateItem(R.string.units1,R.drawable.ic_arrow_down),
            RateItem(R.string.units2,R.drawable.ic_arrow_down),
            RateItem(R.string.units3,R.drawable.ic_arrow_down),
            RateItem(R.string.units4,R.drawable.ic_arrow_down),
            RateItem(R.string.units5,R.drawable.ic_arrow_down),
            RateItem(R.string.units6,R.drawable.ic_arrow_down),
            RateItem(R.string.units7,R.drawable.ic_arrow_down),
            RateItem(R.string.units8,R.drawable.ic_arrow_down),
            RateItem(R.string.units9,R.drawable.ic_arrow_down),
            RateItem(R.string.units10,R.drawable.ic_arrow_down),
            RateItem(R.string.units11,R.drawable.ic_arrow_down),
            RateItem(R.string.units12,R.drawable.ic_arrow_down)
        )
    }

}