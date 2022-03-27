package mening.dasturim.mymobile.data.module


data class InternetItems(
    val name:String? = null,
    val payment:String? = null,
    val expire: String? = null,
    val internet:String? = null,
    val details:String? = null,
    val max_internet:String? = null,
    val min_payment:String? = null,
    val code: String? = null,
    var expanded: Boolean =false
)