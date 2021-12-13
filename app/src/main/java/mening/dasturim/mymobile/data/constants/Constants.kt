package mening.dasturim.mymobile.data.constants

import mening.dasturim.mymobile.data.local.PrefsHelper

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
}