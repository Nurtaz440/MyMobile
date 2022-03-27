package mening.dasturim.mymobile.ui.main.user.ussd

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
import mening.dasturim.mymobile.data.module.UssdItems
import mening.dasturim.mymobile.databinding.FragmentUSSDBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.utils.ViewUtils

class UssdFragment : BaseFragment<FragmentUSSDBinding, USSDVM>() {
    private lateinit var internetAdapter: UssdAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var list: ArrayList<UssdItems>
    private lateinit var code:String
    override fun onBound() {
        setUp()
    }

    fun setUp() {
        ViewUtils.fadeIn(binding.progressBar)

        CompanyState.getCompany().observe(this, Observer {
            when (it) {
                Companies.UZMOBILE -> {
                    internetAdapter.setColorLight(R.color.deep_sky_blue_100)
                    getUzmobile()
                }
                Companies.MOBIUZ -> {
                    internetAdapter.setColorLight(R.color.alizarin_100)
                    getMobiuz()
                }
                Companies.UCELL -> {
                    internetAdapter.setColorLight(R.color.vivid_violet_100)
                    getUcell()
                }
                Companies.BEELINE -> {
                    internetAdapter.setColorLight(R.color.gorse_100)
                    getBeeline()
                }

            }
        })
        list = ArrayList()
        internetAdapter = UssdAdapter(requireContext()) {
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

        binding.rvInternet.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvInternet.adapter = internetAdapter

        firebaseFirestore = FirebaseFirestore.getInstance()

    }

    fun getUzmobile() {
        val query: Query =
            firebaseFirestore.collection("UzMobile").document("USSD kodlar").collection("ussd")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)
                        ViewUtils.fadeOut(binding.progressBar)

                        list.add(document.toObject(UssdItems::class.java)!!)
                        code = document.getString("name")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }

    fun getMobiuz() {
        val query: Query =
            firebaseFirestore.collection("MobiUz").document("USSD kodlar").collection("ussd")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)
                        ViewUtils.fadeOut(binding.progressBar)

                        list.add(document.toObject(UssdItems::class.java)!!)
                        code = document.getString("name")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }

    fun getUcell() {
        val query: Query =
            firebaseFirestore.collection("Ucell").document("USSD kodlar").collection("ussd")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)
                        ViewUtils.fadeOut(binding.progressBar)

                        list.add(document.toObject(UssdItems::class.java)!!)
                        code = document.getString("name")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }

    fun getBeeline() {
        val query: Query =
            firebaseFirestore.collection("Beeline").document("Ussd kodlar").collection("ussd")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)
                        ViewUtils.fadeOut(binding.progressBar)

                        list.add(document.toObject(UssdItems::class.java)!!)
                        code = document.getString("name")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = internetAdapter
                }
            }

        })
    }

    override fun getLayoutResId() = R.layout.fragment_u_s_s_d

    override val vm: USSDVM
        get() = ViewModelProvider(this).get(USSDVM::class.java)


}