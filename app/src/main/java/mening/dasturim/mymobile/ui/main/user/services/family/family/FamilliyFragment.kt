package mening.dasturim.mymobile.ui.main.user.services.family.family

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
import mening.dasturim.mymobile.ui.main.user.services.profite.mbminuts.MbUzbAdapter
import mening.dasturim.mymobile.ui.main.user.services.profite.mbminuts.MbUzbVM

class FamilliyFragment : BaseFragment<FragmentInternetBinding, FamilliyFragmentVM>() {
    private lateinit var mbUzbAdapter: MbUzbAdapter
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
                    mbUzbAdapter.setColor(R.color.deep_sky_blue_400)
                    mbUzbAdapter.setColorLight(R.color.deep_sky_blue_100)
                    getUzmobile()
                }
                Companies.MOBIUZ -> {
                    mbUzbAdapter.setColor(R.color.alizarin_700)
                    mbUzbAdapter.setColorLight(R.color.alizarin_100)
                    getMobiUz()
                }
                Companies.UCELL -> {
                    mbUzbAdapter.setColor(R.color.vivid_violet_800)
                    mbUzbAdapter.setColorLight(R.color.vivid_violet_100)
                }
                Companies.BEELINE -> {
                    mbUzbAdapter.setColor(R.color.gorse_600)
                    mbUzbAdapter.setColorLight(R.color.gorse_100)
                    getBeeline()
                }

            }
        })
        list = ArrayList()
        mbUzbAdapter = MbUzbAdapter(requireContext()) {
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
        mbUzbAdapter.setData(list)


        binding.rvInternet.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvInternet.adapter=mbUzbAdapter

        firebaseFirestore = FirebaseFirestore.getInstance()

    }
    fun getUzmobile(){
        val query: Query =
            firebaseFirestore.collection("UzMobile").document("Xizmatlar").collection("oyla uchun")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(ServiceItmes::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)

                    }
                    binding.rvInternet.adapter = mbUzbAdapter
                }
            }

        })
    }
   fun getMobiUz(){
        val query: Query =
            firebaseFirestore.collection("MobiUz").document("Xizmatlar").collection("Mediabaydan Mobil TV!")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(ServiceItmes::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)

                    }
                    binding.rvInternet.adapter = mbUzbAdapter
                }
            }

        })
    }

    fun getBeeline(){
        val query: Query =
            firebaseFirestore.collection("Beeline").document("Xizmatlar").collection("Daqiqalar va megabaytlarni almashtirish")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(ServiceItmes::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)

                    }
                    binding.rvInternet.adapter = mbUzbAdapter
                }
            }

        })
    }
    override fun getLayoutResId()= R.layout.fragment_internet

    override val vm: FamilliyFragmentVM
        get() = ViewModelProvider(this).get(FamilliyFragmentVM::class.java)
}