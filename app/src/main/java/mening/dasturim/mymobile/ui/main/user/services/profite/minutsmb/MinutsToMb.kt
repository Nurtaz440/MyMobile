package mening.dasturim.mymobile.ui.main.user.services.profite.minutsmb

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
import mening.dasturim.mymobile.data.module.ServiceItmes
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.services.profite.mbminuts.MbUzb
import mening.dasturim.mymobile.ui.main.user.services.profite.mbminuts.MbUzbAdapter

class MinutsToMb : BaseFragment<FragmentInternetBinding, MinutsToMbVM>() {
    private lateinit var myAdapter: MbUzbAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var list: ArrayList<ServiceItmes>
    private lateinit var code:String
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        CompanyState.getCompany().observe(this, Observer {
            when(it){
                Companies.UZMOBILE -> {
                    myAdapter.setColor(R.color.deep_sky_blue_400)
                    myAdapter.setColorLight(R.color.deep_sky_blue_100)
                    getUzmobile()
                }
                Companies.MOBIUZ -> {
                    myAdapter.setColor(R.color.alizarin_700)
                    myAdapter.setColorLight(R.color.alizarin_100)
                    getMobiuz()
                }
                Companies.UCELL -> {
                    myAdapter.setColor(R.color.vivid_violet_800)
                    myAdapter.setColorLight(R.color.vivid_violet_100)
                    getUcell()
                }
                Companies.BEELINE -> {
                    myAdapter.setColor(R.color.gorse_600)
                    myAdapter.setColorLight(R.color.gorse_100)
                    getBeeline()
                }

            }
        })
        list = ArrayList()
        myAdapter = MbUzbAdapter(requireContext()) {
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
        myAdapter.setData(list)


        binding.rvInternet.apply {
            layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter=myAdapter
        }
        firebaseFirestore = FirebaseFirestore.getInstance()


    }
    fun getUzmobile(){
        val query: Query =
            firebaseFirestore.collection("UzMobile").document("Xizmatlar").collection("Foydali almashinuv")
                .document("Sections").collection("MB O‘zbekiston bo‘ylab daqiqalarga")

        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(ServiceItmes::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = myAdapter
                }
            }

        })
    }
    fun getMobiuz(){
        val query: Query =
            firebaseFirestore.collection("MobiUz").document("Xizmatlar").collection("eSIM")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(ServiceItmes::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = myAdapter
                }
            }

        })
    }
    fun getUcell(){
        val query: Query =
            firebaseFirestore.collection("Ucell").document("Xizmatlar").collection("U+")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(ServiceItmes::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = myAdapter
                }
            }

        })
    }

    fun getBeeline(){
        val query: Query =
            firebaseFirestore.collection("Beeline").document("Xizmatlar").collection("eSIM")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(ServiceItmes::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = myAdapter
                }
            }

        })
    }
    override fun getLayoutResId()=R.layout.fragment_internet

    override val vm: MinutsToMbVM
        get() = ViewModelProvider(this).get(MinutsToMbVM::class.java)


}