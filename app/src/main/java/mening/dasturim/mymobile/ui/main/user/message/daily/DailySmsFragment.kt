package mening.dasturim.mymobile.ui.main.user.message.daily

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
import mening.dasturim.mymobile.data.module.SmsItems
import mening.dasturim.mymobile.data.module.TariffItems
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.tariff.units.UnitsAdapter

class DailySmsFragment : BaseFragment<FragmentInternetBinding, DailySmsVM>() {
    private lateinit var internetAdapter: DailySmsAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore
    private var list= ArrayList<SmsItems>()
    private lateinit var code:String
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    internetAdapter.setColor(R.color.deep_sky_blue_400)
                    internetAdapter.setColorLight(R.color.deep_sky_blue_100)
                    getUzmobile()
                }
                Companies.MOBIUZ -> {
                    internetAdapter.setColor(R.color.alizarin_700)
                    internetAdapter.setColorLight(R.color.alizarin_100)
                    getMobiuz()
                }
                Companies.UCELL -> {
                    internetAdapter.setColor(R.color.vivid_violet_800)
                    internetAdapter.setColorLight(R.color.vivid_violet_100)
                    getUcell()
                }
                Companies.BEELINE -> {
                    internetAdapter.setColor(R.color.gorse_600)
                    internetAdapter.setColorLight(R.color.gorse_100)
                    getBeeline()
                }

            }
        })
        internetAdapter= DailySmsAdapter(requireContext()) {
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
        internetAdapter.setData(list)

        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=internetAdapter

        firebaseFirestore = FirebaseFirestore.getInstance()


    }


    fun getUzmobile(){
        val query: Query =
            firebaseFirestore.collection("UzMobile").document("SMS paketlar").collection("Kunlik SMS")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(SmsItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }
    fun getMobiuz(){
        val query: Query =
            firebaseFirestore.collection("MobiUz").document("SMS paketlar").collection("SMS-OnNet")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(SmsItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }
    fun getUcell(){
        val query: Query =
            firebaseFirestore.collection("Ucell").document("Sms paketlar").collection("Kunlik SMS")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(SmsItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }

    fun getBeeline(){
        val query: Query =
            firebaseFirestore.collection("Beeline").document("Sms paketlar").collection("20 SMS paketi")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(SmsItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }

    override fun getLayoutResId()=R.layout.fragment_internet

    override val vm: DailySmsVM
        get() = ViewModelProvider(this).get(DailySmsVM::class.java)


}