package mening.dasturim.mymobile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mening.dasturim.mymobile.ui.base.BaseVM

object CompanyState {
    const val uzmobile=0
    const val mobiuz=1
    const val ucell=2
    const val beeline=3
    private val company=MutableLiveData<Int>()

    fun getCompany():LiveData<Int>{
        return company
    }

    fun setCompany(company:Int){
        this.company.value=company
    }



}