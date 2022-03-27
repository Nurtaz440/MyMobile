package mening.dasturim.mymobile.ui.main.user.tariff.privilege

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.data.module.TariffItems
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.utils.ViewUtils

class PrivilegeFragment : BaseFragment<FragmentInternetBinding,PrivilegeVM>() {
    private  lateinit var privilegeAdapter: PrivilegeAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var list: ArrayList<TariffItems>
    private lateinit var code:String
    override fun onBound() {

        setUp()
    }

    fun setUp(){
      //  ViewUtils.fadeIn(binding.progressBar)

        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    privilegeAdapter.setColorIcon(R.color.deep_sky_blue_400)
                    privilegeAdapter.setColorLight(R.color.deep_sky_blue_100)
                    getUzmobile()
                }
                Companies.MOBIUZ -> {
                    privilegeAdapter.setColorIcon(R.color.alizarin_700)
                    privilegeAdapter.setColorLight(R.color.alizarin_100)
                    getMobiuz()
                }
                Companies.UCELL -> {
                    privilegeAdapter.setColorIcon(R.color.vivid_violet_800)
                    privilegeAdapter.setColorLight(R.color.vivid_violet_100)
                    getUcell()
                }
                Companies.BEELINE -> {
                    privilegeAdapter.setColorIcon(R.color.gorse_600)
                    privilegeAdapter.setColorLight(R.color.gorse_100)
                    getBeeline()
                }
            }
        })
        list = ArrayList()
        privilegeAdapter = PrivilegeAdapter(requireContext()) {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + Uri.encode(code))
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    9
                )
            } else {
                startActivity(intent)
            }
        }
        privilegeAdapter.setData(list)

        binding.rvInternet.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvInternet.adapter=privilegeAdapter

        firebaseFirestore = FirebaseFirestore.getInstance()


    }
    fun getMobiuz(){
        val query: Query =
            firebaseFirestore.collection("MobiUz").document("Tariflar").collection("Yillik tariflar")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)
                  //      ViewUtils.fadeOut(binding.progressBar)

                        list.add(document.toObject(TariffItems::class.java)!!)

                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = privilegeAdapter
                }
            }

        })
    }
    fun getUzmobile(){
        val query: Query =
            firebaseFirestore.collection("UzMobile").document("Tariflar").collection("Imtiyozli")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)
                      //  ViewUtils.fadeOut(binding.progressBar)

                        list.add(document.toObject(TariffItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = privilegeAdapter
                }
            }

        })
    }
    fun getUcell(){
        val query: Query =
            firebaseFirestore.collection("Ucell").document("Tariflar").collection("Marxamat")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)


                        list.add(document.toObject(TariffItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = privilegeAdapter
                }
            }

        })
    }
    fun getBeeline(){
        val query: Query =
            firebaseFirestore.collection("Beeline").document("Tariflar").collection("Kunlik")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(TariffItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = privilegeAdapter
                }
            }

        })
    }
    override fun getLayoutResId()=R.layout.fragment_internet

    override val vm: PrivilegeVM
        get() = ViewModelProvider(this).get(PrivilegeVM::class.java)


}