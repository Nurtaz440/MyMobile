package mening.dasturim.mymobile.data.module


data class SmsItems(
    val name:String? = null,
    val payment:String? = null,
    val expire: String? = null,
    val sms:String? = null,
    val details:String? = null,
    val code: String? = null,
    var expanded: Boolean =false
)