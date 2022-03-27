package mening.dasturim.mymobile.ui.main.user.internet.megabayt

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
import mening.dasturim.mymobile.data.module.InternetItems
import mening.dasturim.mymobile.data.module.TariffItems
import mening.dasturim.mymobile.databinding.FragmentInternetBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.ui.main.user.internet.megaboom.MegaBoomAdapter
import mening.dasturim.mymobile.ui.main.user.tariff.best.BestFragmentAdapter
import mening.dasturim.mymobile.ui.main.user.tariff.best.BestFragmentVM

class MegabaytFragment  : BaseFragment<FragmentInternetBinding, BestFragmentVM>() {
    private lateinit var rateAdapter: MegaBoomAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var list: ArrayList<InternetItems>
    private lateinit var code:String
    override fun onBound() {

        setUp()
    }

    fun setUp() {

        CompanyState.getCompany().observe(this, Observer {
            when (it) {
                Companies.UZMOBILE -> {
                    rateAdapter.setColor(R.color.deep_sky_blue_400)
                    rateAdapter.setColorLight(R.color.deep_sky_blue_100)
                }
                Companies.MOBIUZ -> {
                    rateAdapter.setColor(R.color.alizarin_700)
                    rateAdapter.setColorLight(R.color.alizarin_100)
                }
                Companies.UCELL -> {
                    rateAdapter.setColor(R.color.vivid_violet_800)
                    rateAdapter.setColorLight(R.color.vivid_violet_100)
                    getUcell()
                }
                Companies.BEELINE -> {
                    rateAdapter.setColor(R.color.gorse_600)
                    rateAdapter.setColorLight(R.color.gorse_100)
                }
            }
        })
        list = ArrayList()
        rateAdapter = MegaBoomAdapter(requireContext()) {
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
        rateAdapter.setData(list)


        binding.rvInternet.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.rvInternet.adapter = rateAdapter

        firebaseFirestore = FirebaseFirestore.getInstance()

    }

    override fun getLayoutResId() = R.layout.fragment_internet

    override val vm: BestFragmentVM
        get() = ViewModelProvider(this).get(BestFragmentVM::class.java)

    fun getUcell(){
        val query: Query =
            firebaseFirestore.collection("Ucell").document("Internet paketlar").collection("Megabaytlar qaytadi")


        query.get().addOnCompleteListener(object : OnCompleteListener<QuerySnapshot?> {
            override fun onComplete(p0: Task<QuerySnapshot?>) {
                if (p0.isSuccessful) {
                    for (document: DocumentSnapshot in p0.result!!) {
                        Log.d("Route Fragment", "onComplete: query " + document)

                        list.add(document.toObject(InternetItems::class.java)!!)
                        code = document.getString("code")!!
                        Log.d("Route Fragment", "onComplete: query " + code)
                    }
                    binding.rvInternet.adapter = rateAdapter
                }
            }

        })
    }

}