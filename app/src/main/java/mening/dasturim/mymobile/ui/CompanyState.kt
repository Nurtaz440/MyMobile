package mening.dasturim.mymobile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mening.dasturim.mymobile.ui.base.BaseVM

object CompanyState {
    private val company=MutableLiveData<Companies>()

    fun getCompany():LiveData<Companies>{
        return company
    }

    fun setCompany(company:Companies){
        this.company.value=company
    }
}

enum class  Companies{
    UZMOBILE,MOBIUZ,UCELL,BEELINE
}