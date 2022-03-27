package mening.dasturim.mymobile.data.module



data class MinutItems(
    val name:String? = null,
    val payment:String? = null,
    val expire: String? = null,
    val call:String? = null,
    val sms:String? = null,
    val internet:String? = null,
    val details:String? = null,
    val code: String? = null,
    var expanded: Boolean =false
)