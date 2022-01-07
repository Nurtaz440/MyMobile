package mening.dasturim.mymobile.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import mening.dasturim.mymobile.data.constants.Keys
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.utils.put

class PrefsHelper(
    private val gson: Gson,
    private val preferences: SharedPreferences
) {

    var company:Int
    get() = preferences.getInt(Keys.COMPANIES,CompanyState.uzmobile)
    set(value)=preferences.put(Keys.COMPANIES,value)

    var language: String?
        get() = preferences.getString(Keys.LANGUAGE, null)
        set(value) = preferences.put(Keys.LANGUAGE, value)

    var isRegistered: Boolean
        get() = preferences.getBoolean(Keys.IS_REGISTERED, false)
        set(value) = preferences.put(Keys.IS_REGISTERED, value)

    var accessToken: String?
        get() = preferences.getString(Keys.ACCESS_TOKEN, null)
        set(value) = preferences.put(Keys.ACCESS_TOKEN, value)

    var phoneNumber:String?
    get() = preferences.getString(Keys.PHONE_NUMBER,null)
    set(value) = preferences.put(Keys.PHONE_NUMBER,value)

    var refreshToken:String?
    get() = preferences.getString(Keys.REFRESH_TOKEN,null)
    set(value) = preferences.put(Keys.REFRESH_TOKEN,value)

    var password : String?
    get() = preferences.getString(Keys.PASSWORD,null)
    set(value) = preferences.put(Keys.PASSWORD,value)

    var tokeanExpiry :Long
    get() = preferences.getLong(Keys.TOKEN_EXPIRY,0)
    set(value) = preferences.put(Keys.TOKEN_EXPIRY,value)

    var lastUpdatePromptTime:Long
    get() = preferences.getLong(Keys.LAST_UPDATE_PROMPT,0)
    set(value) = preferences.put(Keys.LAST_UPDATE_PROMPT,value)

    var cardNumber:String?
    get()= preferences.getString(Keys.CARD_NUMBER,null)
    set(value) = preferences.put(Keys.CARD_NUMBER,value)

}