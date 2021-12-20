package mening.dasturim.mymobile.data.constants

import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.local.PrefsHelper
import mening.dasturim.mymobile.data.module.RateItem

object Constants {
    lateinit var prefs: PrefsHelper

    var language = ""

    const val LANGUAGE_RUSSIAN: String = "ru"
    const val LANGUAGE_UZBEK: String = "uz"
    const val LANGUAGE_ENGLISH: String = "en"

    const val CALL_CENTER_NUMBER_UZMOBILE = "1084"
    const val CALL_CENTER_NUMBER_MOBIEUZ = "0870"
    const val CALL_CENTER_NUMBER_UCELL = "8123"
    const val CALL_CENTER_NUMBER_BEELINE = "0639"

    fun getRateItems(): ArrayList<RateItem> {
        return arrayListOf(
            RateItem(
                R.string.units1,
                R.drawable.ic_arrow_down,
                R.string.tolov,
                R.string.unit,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units2,
                R.drawable.ic_arrow_down,
                R.string.tolov2,
                R.string.unit2,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units3,
                R.drawable.ic_arrow_down,
                R.string.tolov3,
                R.string.unit3,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units4,
                R.drawable.ic_arrow_down,
                R.string.tolov4,
                R.string.unit4,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units5,
                R.drawable.ic_arrow_down,
                R.string.tolov5,
                R.string.unit5,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units6,
                R.drawable.ic_arrow_down,
                R.string.tolov6,
                R.string.unit6,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units7,
                R.drawable.ic_arrow_down,
                R.string.tolov7,
                R.string.unit7,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units8,
                R.drawable.ic_arrow_down,
                R.string.tolov8,
                R.string.unit8,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units9,
                R.drawable.ic_arrow_down,
                R.string.tolov9,
                R.string.unit9,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units10,
                R.drawable.ic_arrow_down,
                R.string.tolov10,
                R.string.unit10,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units11,
                R.drawable.ic_arrow_down,
                R.string.tolov11,
                R.string.unit11,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            ),
            RateItem(
                R.string.units12,
                R.drawable.ic_arrow_down,
                R.string.tolov12,
                R.string.unit12,
                R.string.mobile_unit,
                R.string.mobile_unit,
                R.string.mobile_unit
            )
        )
    }

    fun getNationItems(): ArrayList<RateItem> {
        return arrayListOf(
            RateItem(
                R.string.milliy1,
                R.drawable.ic_arrow_down,
                R.string.tolov_milliy,
                R.string.nation_minuts,
                R.string.nation_minuts,
                R.string.nation_mg,
                R.string.nation_sms
            ),
            RateItem(
                R.string.milliy2,
                R.drawable.ic_arrow_down,
                R.string.tolov_milliy2,
                R.string.nation_minuts,
                R.string.nation_minuts,
                R.string.nation_mg,
                R.string.nation_sms
            ),
            RateItem(
                R.string.milliy3,
                R.drawable.ic_arrow_down,
                R.string.tolov_milliy3,
                R.string.nation_minuts,
                R.string.nation_minuts,
                R.string.nation_mg,
                R.string.nation_sms
            ),
            RateItem(
                R.string.milliy4,
                R.drawable.ic_arrow_down,
                R.string.tolov_milliy4,
                R.string.nation_minuts,
                R.string.nation_minuts,
                R.string.nation_mg,
                R.string.nation_sms
            ),
            RateItem(
                R.string.milliy5,
                R.drawable.ic_arrow_down,
                R.string.tolov_milliy5,
                R.string.nation_minuts,
                R.string.nation_minuts,
                R.string.nation_mg,
                R.string.nation_sms
            ),
            RateItem(
                R.string.milliy6,
                R.drawable.ic_arrow_down,
                R.string.tolov_milliy6,
                R.string.nation_minuts,
                R.string.nation_minuts,
                R.string.nation_mg,
                R.string.nation_sms
            ),
            RateItem(
                R.string.milliy7,
                R.drawable.ic_arrow_down,
                R.string.tolov_milliy7,
                R.string.nation_minuts,
                R.string.nation_minuts,
                R.string.nation_mg,
                R.string.nation_sms
            )

        )
    }


}