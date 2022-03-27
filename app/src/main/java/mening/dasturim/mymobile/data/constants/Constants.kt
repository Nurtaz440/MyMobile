package mening.dasturim.mymobile.data.constants

import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.local.PrefsHelper
import mening.dasturim.mymobile.data.module.*

object Constants {
    lateinit var prefs: PrefsHelper

    var language = ""

    const val LANGUAGE_RUSSIAN: String = "ru"
    const val LANGUAGE_UZBEK: String = "uz"
    const val LANGUAGE_ENGLISH: String = "en"

    const val CALL_CENTER_NUMBER_UZMOBILE = "1099"
    const val CALL_CENTER_NUMBER_MOBIEUZ = "0890"
    const val CALL_CENTER_NUMBER_UCELL = "8123"
    const val CALL_CENTER_NUMBER_BEELINE = "0611"

    const val CALL_BALANS = "*100#"
    const val CALL_BALANS_BEELINE = "*102#"

    fun getSettingsItems(): ArrayList<SettingsItems> {
        return arrayListOf(
            SettingsItems(R.string.ulashish),
            SettingsItems(R.string.baho),
            SettingsItems(R.string.boglanish)
        )
    }

    fun getServiceItems(): ArrayList<SettingsItems> {
        return arrayListOf(
            SettingsItems(R.string.foydali_almashinuv),
            SettingsItems(R.string.limitsiz_ovoz),
            SettingsItems(R.string.tungi_internet),
            SettingsItems(R.string.ziyonet),
            SettingsItems(R.string.tezkor_otkazmalar)
        )
    }
    fun getMobiUzServices():ArrayList<SettingsItems>{
        return arrayListOf(
            SettingsItems(R.string.ballar),
            SettingsItems(R.string.foydali_almashinuv),
            SettingsItems(R.string.vada_qilingan),
            SettingsItems(R.string.xr_ulanish)
        )
    }
 fun getUcellServices():ArrayList<SettingsItems>{
        return arrayListOf(
            SettingsItems(R.string.u),
            SettingsItems(R.string.jismoniy),
            SettingsItems(R.string.sms_imzo),
            SettingsItems(R.string.meni_xizmatim),
            SettingsItems(R.string.maxfiy_qongiroq),
            SettingsItems(R.string.dtm),
            SettingsItems(R.string.iTV)
        )
    }
fun getBeelineServices():ArrayList<SettingsItems>{
        return arrayListOf(
            SettingsItems(R.string.beep),
            SettingsItems(R.string.xizmat),
            SettingsItems(R.string.my_number),
            SettingsItems(R.string.find)
        )
    }

    fun getHomeItems(): ArrayList<HomeItems> {
        return arrayListOf(
            HomeItems(R.drawable.ic_rate, R.string.tariflar),
            HomeItems(R.drawable.ic_internet_pockets, R.string.internet_paketlar),
            HomeItems(R.drawable.ic_call_add, R.string.daqiqalar),
            HomeItems(R.drawable.ic_message, R.string.sms_paketlar),
            HomeItems(R.drawable.ic_ussd_code, R.string.ussd_kodlar),
            HomeItems(R.drawable.ic_service, R.string.xizmatlar)
        )
    }
}