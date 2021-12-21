package mening.dasturim.mymobile.data.constants

import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.local.PrefsHelper
import mening.dasturim.mymobile.data.module.DailyItems
import mening.dasturim.mymobile.data.module.NonStopItem
import mening.dasturim.mymobile.data.module.RateItem
import mening.dasturim.mymobile.data.module.USSDItems

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


    fun getPrivilegeItems(): ArrayList<RateItem> {
        return arrayListOf(
            RateItem(
                R.string.talim,
                R.drawable.ic_arrow_down,
                R.string.talim_tolov,
                R.string.imt_limit,
                R.string.imt_mituts,
                R.string.imt_mg,
                R.string.imt_sms
            ),
            RateItem(
                R.string.maktab,
                R.drawable.ic_arrow_down,
                R.string.maktab_tollov,
                R.string.imt_limit2,
                R.string.imt_mituts2,
                R.string.imt_mg2,
                R.string.imt_sms2
            ),
            RateItem(
                R.string.bolajon,
                R.drawable.ic_arrow_down,
                R.string.bolajon_tolov,
                R.string.imt_limit3,
                R.string.imt_mituts3,
                R.string.imt_mg3,
                R.string.imt_sms3
            ),
            RateItem(
                R.string.yoshlar,
                R.drawable.ic_arrow_down,
                R.string.yoshlar_tolov,
                R.string.imt_limit4,
                R.string.imt_mituts4,
                R.string.imt_mg4,
                R.string.imt_sms4
            )
        )
    }

fun getM2MItems(): ArrayList<RateItem> {
        return arrayListOf(
            RateItem(
                R.string.uzmobile_m2m,
                R.drawable.ic_arrow_down,
                R.string.m2m_tolov,
                R.string.m2m_limit,
                R.string.m2m_minuts,
                R.string.m2m_mb,
                R.string.m2m_sms
            ),
            RateItem(
                R.string.m2m_basic,
                R.drawable.ic_arrow_down,
                R.string.m2m_tolov2,
                R.string.m2m_limit2,
                R.string.m2m_minuts2,
                R.string.m2m_mb2,
                R.string.m2m_sms2
            ),
            RateItem(
                R.string.uzcard_gsm,
                R.drawable.ic_arrow_down,
                R.string.m2m_tolov3,
                R.string.m2m_limit3,
                R.string.m2m_minuts3,
                R.string.m2m_mb3,
                R.string.m2m_sms3
            ),
            RateItem(
                R.string.humo,
                R.drawable.ic_arrow_down,
                R.string.m2m_tolov4,
                R.string.m2m_limit4,
                R.string.m2m_minuts4,
                R.string.m2m_mb4,
                R.string.m2m_sms4
            ),
          RateItem(
                R.string.m2m_uzmobile,
                R.drawable.ic_arrow_down,
                R.string.m2m_tolov5,
                R.string.m2m_limit5,
                R.string.m2m_minuts5,
                R.string.m2m_mb5,
                R.string.m2m_sms5
            )

        )
    }

    fun getNotStopItems(): ArrayList<NonStopItem> {
        return arrayListOf(
            NonStopItem(
                R.string.non_stop,
                R.drawable.ic_arrow_down,
                R.string.non_stop_tolov,
                R.string.non_stop_tolov,
                R.string.non_stop_mb
            ),
            NonStopItem(
                R.string.non_stop2,
                R.drawable.ic_arrow_down,
                R.string.non_stop_tolov2,
                R.string.non_stop_tolov2,
                R.string.non_stop_mb2

            ),
            NonStopItem(
                R.string.non_stop3,
                R.drawable.ic_arrow_down,
                R.string.non_stop_tolov3,
                R.string.non_stop_tolov3,
                R.string.non_stop_mb3
            )
        )
    }
    fun getDailyItems(): ArrayList<DailyItems> {
        return arrayListOf(
            DailyItems(
                R.string.daily_name,
                R.drawable.ic_arrow_down,
                R.string.daily_pay1,
                R.string.daily_limit
            ),
            DailyItems(
                R.string.daily_name2,
                R.drawable.ic_arrow_down,
                R.string.daily_pay2,
                R.string.daily_limit2

            ),
            DailyItems(
                R.string.daily_name3,
                R.drawable.ic_arrow_down,
                R.string.daily_pay3,
                R.string.daily_limit3

            )
        )
    }

    fun getInternetPocketsItems(): ArrayList<DailyItems> {
        return arrayListOf(
            DailyItems(
                R.string.internet,
                R.drawable.ic_arrow_down,
                R.string.internet_payment,
                R.string.deadline_day
            ),
            DailyItems(
                R.string.internet1,
                R.drawable.ic_arrow_down,
                R.string.internet_payment1,
                R.string.deadline_day

            ),
            DailyItems(
                R.string.internet2,
                R.drawable.ic_arrow_down,
                R.string.internet_payment2,
                R.string.deadline_day

            ),
            DailyItems(
                R.string.internet3,
                R.drawable.ic_arrow_down,
                R.string.internet_payment3,
                R.string.deadline_day
            ),
            DailyItems(
                R.string.internet4,
                R.drawable.ic_arrow_down,
                R.string.internet_payment4,
                R.string.deadline_day

            ),
            DailyItems(
                R.string.internet5,
                R.drawable.ic_arrow_down,
                R.string.internet_payment5,
                R.string.deadline_day

            ),
            DailyItems(
                R.string.internet6,
                R.drawable.ic_arrow_down,
                R.string.internet_payment6,
                R.string.deadline_day
            ),
            DailyItems(
                R.string.internet7,
                R.drawable.ic_arrow_down,
                R.string.internet_payment7,
                R.string.deadline_day

            ),
            DailyItems(
                R.string.internet8,
                R.drawable.ic_arrow_down,
                R.string.internet_payment8,
                R.string.deadline_day

            ),
            DailyItems(
                R.string.internet9,
                R.drawable.ic_arrow_down,
                R.string.internet_payment9,
                R.string.deadline_day
            ),
            DailyItems(
                R.string.internet10,
                R.drawable.ic_arrow_down,
                R.string.internet_payment10,
                R.string.deadline_day

            )
        )
    }

    fun getTasixItems(): ArrayList<NonStopItem> {
        return arrayListOf(
            NonStopItem(
                R.string.tasix_name,
                R.drawable.ic_arrow_down,
                R.string.tasix_payment,
                R.string.tasix_mb,
                R.string.tasix_day
            ),
            NonStopItem(
                R.string.tasix_name2,
                R.drawable.ic_arrow_down,
                R.string.tasix_payment2,
                R.string.tasix_mb2,
                R.string.tasix_day

            ),
            NonStopItem(
                R.string.tasix_name3,
                R.drawable.ic_arrow_down,
                R.string.tasix_payment3,
                R.string.tasix_mb3,
                R.string.tasix_day
            )
        )
    }

    fun getInterNonStopItems(): ArrayList<NonStopItem> {
        return arrayListOf(
            NonStopItem(
                R.string.internet_non_stop2,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment2,
                R.string.internet_non_stop_pay_month2,
                R.string.internet_non_stop2
            ),
            NonStopItem(
                R.string.internet_non_stop3,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment3,
                R.string.internet_non_stop_pay_month3,
                R.string.internet_non_stop3

            ),
            NonStopItem(
                R.string.internet_non_stop4,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment4,
                R.string.internet_non_stop_pay_month4,
                R.string.internet_non_stop4
            ),
            NonStopItem(
                R.string.internet_non_stop5,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment5,
                R.string.internet_non_stop_pay_month5,
                R.string.internet_non_stop5
            ),
            NonStopItem(
                R.string.internet_non_stop6,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment6,
                R.string.internet_non_stop_pay_month2,
                R.string.internet_non_stop6

            ),
            NonStopItem(
                R.string.internet_non_stop7,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment7,
                R.string.internet_non_stop_pay_month7,
                R.string.internet_non_stop7
            ),
            NonStopItem(
                R.string.internet_non_stop8,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment8,
                R.string.internet_non_stop_pay_month8,
                R.string.internet_non_stop8
            ),
            NonStopItem(
                R.string.internet_non_stop9,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment9,
                R.string.internet_non_stop_pay_month9,
                R.string.internet_non_stop9

            ),
            NonStopItem(
                R.string.internet_non_stop10,
                R.drawable.ic_arrow_down,
                R.string.internet_non_stop_payment10,
                R.string.internet_non_stop_pay_month10,
                R.string.internet_non_stop10
            )
        )
    }

    fun getMinutesItems(): ArrayList<DailyItems> {
        return arrayListOf(
            DailyItems(
                R.string.minutes_name,
                R.drawable.ic_arrow_down,
                R.string.daily_pay1,
                R.string.daily_limit
            ),
            DailyItems(
                R.string.minutes_name,
                R.drawable.ic_arrow_down,
                R.string.daily_pay2,
                R.string.daily_limit2

            ),
            DailyItems(
                R.string.minutes_name,
                R.drawable.ic_arrow_down,
                R.string.daily_pay3,
                R.string.daily_limit3

            )
        )
    }
    fun getUssdItems():ArrayList<USSDItems>{
        return arrayListOf(
            USSDItems(R.string.ussd,R.string.ussd_describe),
            USSDItems(R.string.ussd2,R.string.ussd_describe2),
            USSDItems(R.string.ussd3,R.string.ussd_describe3),
            USSDItems(R.string.ussd4,R.string.ussd_describe4),
            USSDItems(R.string.ussd5,R.string.ussd_describe5),
            USSDItems(R.string.ussd6,R.string.ussd_describe6),
            USSDItems(R.string.ussd7,R.string.ussd_describe7),
            USSDItems(R.string.ussd8,R.string.ussd_describe8)
        )
    }
}