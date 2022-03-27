package mening.dasturim.mymobile.ui.main.user.internet.paketlar


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
import mening.dasturim.mymobile.data.module.InternetItems
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class DailyFragment : BaseFragment<FragmentInternetBinding,DailyPocketsVM>() {
    private lateinit var dailyAdapter: DailyAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var list: ArrayList<InternetItems>
    private lateinit var code:String
    override fun onBound() {
       setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    dailyAdapter.setColor(R.color.deep_sky_blue_400)
                    dailyAdapter.setColorLight(R.color.deep_sky_blue_100)
                    getUzmobile()
                }
                Companies.MOBIUZ -> {
                    dailyAdapter.setColor(R.color.alizarin_700)
                    dailyAdapter.setColorLight(R.color.alizarin_100)
                    getMobiuz()
                }
                Companies.UCELL -> {
                    dailyAdapter.setColor(R.color.vivid_violet_800)
                    dailyAdapter.setColorLight(R.color.vivid_violet_100)
                    getUcell()
                }
                Companies.BEELINE -> {
                    dailyAdapter.setColor(R.color.gorse_600)
                    dailyAdapter.setColorLight(R.color.gorse_100)
                    getBeeline()
                }

            }
        })
        list= ArrayList()
        dailyAdapter = DailyAdapter(requireContext()) {
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
        dailyAdapter.setData(list)

        binding.rvInternet.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvInternet.adapter=dailyAdapter

        firebaseFirestore= FirebaseFirestore.getInstance()

    }
    fun getUzmobile(){
        val query: Query =
            firebaseFirestore.collection("UzMobile").document("Internet paketlar").collection("Kunlik paketlar")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(InternetItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = dailyAdapter
                }
            }

        })
    }
    fun getMobiuz(){
        val query: Query =
            firebaseFirestore.collection("MobiUz").document("Internet paketlar").collection("Tungi DRIVE")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(InternetItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = dailyAdapter
                }
            }

        })
    }
    fun getUcell(){
        val query: Query =
            firebaseFirestore.collection("Ucell").document("Internet paketlar").collection("Kunlik Internet")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(InternetItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = dailyAdapter
                }
            }

        })
    }

    fun getBeeline() {
        val query: Query =
            firebaseFirestore.collection("Beeline").document("Internet paketlar")
                .collection("Kunlik Internet tariflar ")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(InternetItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = dailyAdapter
                }
            }

        })
    }


    override fun getLayoutResId()=R.layout.fragment_internet

    override val vm: DailyPocketsVM
        get() = ViewModelProvider(this).get(DailyPocketsVM::class.java)


}