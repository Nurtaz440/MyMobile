package mening.dasturim.mymobile.data.module


data class TariffItems(
    val name: String? = null,
    val payment: String? = null,
    val expire: String? = null,
    val internet: String? = null,
    val internet_out: String? = null,
    val call: String? = null,
    val callout: String? = null,
    val sms: String? = null,
    val sms_out: String? = null,
    val cashback: String? = null,
    val details: String? = null,
    val code: String? = null,
    var expanded: Boolean =false
 )

