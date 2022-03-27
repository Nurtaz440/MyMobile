package mening.dasturim.mymobile.ui.main.user.tariff.m2m


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
import mening.dasturim.mymobile.data.module.TariffItems
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.utils.ViewUtils

class M2mFragment : BaseFragment<FragmentInternetBinding, M2mVM>() {
    private lateinit var m2mAdapter: M2mAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var list: ArrayList<TariffItems>
    private lateinit var code:String
    override fun onBound() {
        setUp()
    }

    fun setUp() {
       // ViewUtils.fadeIn(binding.progressBar)
        CompanyState.getCompany().observe(this, Observer {
            when (it) {
                Companies.UZMOBILE -> {
                    m2mAdapter.setColor(R.color.deep_sky_blue_400)
                    m2mAdapter.setColorLight(R.color.deep_sky_blue_100)
                    getUzmobile()
                }
                Companies.MOBIUZ -> {
                    m2mAdapter.setColor(R.color.alizarin_700)
                    m2mAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    m2mAdapter.setColor(R.color.vivid_violet_800)
                    m2mAdapter.setColorLight(R.color.vivid_violet_100)
                    getUcell()
                }
                Companies.BEELINE -> {
                    m2mAdapter.setColor(R.color.gorse_600)
                    m2mAdapter.setColorLight(R.color.gorse_100)
                    getBeeline()
                }

            }
        })

        list = ArrayList()
        m2mAdapter = M2mAdapter(requireContext()) {
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
        m2mAdapter.setData(list)

        binding.rvInternet.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvInternet.adapter = m2mAdapter
        firebaseFirestore = FirebaseFirestore.getInstance()


    }

    override fun getLayoutResId() = R.layout.fragment_internet
    override val vm: M2mVM
        get() = ViewModelProvider(this).get(M2mVM::class.java)

    fun getUzmobile() {
        val query: Query =
            firebaseFirestore.collection("UzMobile").document("Tariflar").collection("M2M")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(TariffItems::class.java)!!)

                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = m2mAdapter
                }
            }

        })
    }

    fun getUcell() {
        val query: Query =
            firebaseFirestore.collection("Ucell").document("Tariflar").collection("Tantana")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(TariffItems::class.java)!!)

                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = m2mAdapter
                }
            }

        })
    }

    fun getBeeline() {
        val query: Query =
            firebaseFirestore.collection("Beeline").document("Tariflar").collection("Status Silver")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(TariffItems::class.java)!!)

                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = m2mAdapter
                }
            }

        })
    }


}