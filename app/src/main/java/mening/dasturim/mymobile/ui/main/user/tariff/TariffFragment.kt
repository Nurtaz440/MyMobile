package mening.dasturim.mymobile.ui.main.user.tariff

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.databinding.FragmentInternetPocketsBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.utils.ViewUtils


class TariffFragment : BaseFragment<FragmentInternetPocketsBinding, TariffVM>() {
    private lateinit var fragmentAdapter: ViewPagerAdapter
    private lateinit var firebaseFirestore: FirebaseFirestore

    override fun onBound() {
        setUp()
    }

    @SuppressLint("LogConditional")
    fun setUp() {
        ViewUtils.fadeIn(binding.progressBar)
        fragmentAdapter = ViewPagerAdapter(requireFragmentManager(), requireActivity().lifecycle)
        firebaseFirestore = FirebaseFirestore.getInstance()


        CompanyState.getCompany().observe(this, Observer { it ->
            if (it != null) {
                when (it) {
                    Companies.UZMOBILE -> {
                        binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.deep_sky_blue_400))

                        firebaseFirestore.collection("UzMobile").document("Tariflar").get()
                            .addOnCompleteListener(object : OnCompleteListener<DocumentSnapshot?> {
                                override fun onComplete(p0: Task<DocumentSnapshot?>) {
                                    if (p0.isSuccessful) {


                                        Log.d("Route Fragment", "onComplete: query " + p0)
                                        ViewUtils.fadeOut(binding.progressBar)

                                        p0.result?.let {

                                            val list: List<String> = it.get("cpllections") as ArrayList<String>
                                            fragmentAdapter.setData(list)
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[3]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[0]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[2]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[1]))
                                        }
                                    }
                                }

                            })

                    }
                    Companies.MOBIUZ -> {
                        binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.alizarin_700))
                        firebaseFirestore.collection("MobiUz").document("Tariflar").get()
                            .addOnCompleteListener(object : OnCompleteListener<DocumentSnapshot?> {
                                override fun onComplete(p0: Task<DocumentSnapshot?>) {
                                    if (p0.isSuccessful) {
                                        Log.d("Route Fragment", "onComplete: query " + p0)
                                        ViewUtils.fadeOut(binding.progressBar)

                                        p0.result?.let {

                                            val list: List<String> =
                                                it.get("collections") as ArrayList<String>
                                            fragmentAdapter.setData(list)
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[0]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[2]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[1]))
                                        }
                                    }
                                }

                            })
                    }
                    Companies.BEELINE -> {
                        binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.gorse_600))
                        firebaseFirestore.collection("Beeline").document("Tariflar").get()
                            .addOnCompleteListener(object : OnCompleteListener<DocumentSnapshot?> {
                                override fun onComplete(p0: Task<DocumentSnapshot?>) {
                                    if (p0.isSuccessful) {
                                        Log.d("Route Fragment", "onComplete: query " + p0)
                                        ViewUtils.fadeOut(binding.progressBar)

                                        p0.result?.let {

                                            val list: List<String> =
                                                it.get("collections") as ArrayList<String>
                                            fragmentAdapter.setData(list)
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[0]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[1]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[2]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[3]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[4]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[5]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[6]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[7]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[8]))
                                        }
                                    }
                                }

                            })
                    }
                    Companies.UCELL -> {
                        binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.vivid_violet_800))
                        firebaseFirestore.collection("Ucell").document("Tariflar").get()
                            .addOnCompleteListener(object : OnCompleteListener<DocumentSnapshot?> {
                                override fun onComplete(p0: Task<DocumentSnapshot?>) {
                                    if (p0.isSuccessful) {
                                        Log.d("Route Fragment", "onComplete: query " + p0)
                                        ViewUtils.fadeOut(binding.progressBar)

                                        p0.result?.let {

                                            val list: List<String> =
                                                it.get("collections") as ArrayList<String>
                                            fragmentAdapter.setData(list)
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[0]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[2]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[3]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[4]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[1]))
                                            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list[5]))
                                        }
                                    }
                                }
                            })
                    }
                }

            } else {
                CompanyState.setCompany(Companies.UZMOBILE)
                prefs.company = Companies.UZMOBILE.name
            }

        })

        binding.viewPager.adapter = fragmentAdapter
        binding.viewPager.offscreenPageLimit = 1


        binding.tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    binding.viewPager.currentItem = tab?.position!!
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })

        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
                }
            })
    }

    override fun getLayoutResId() = R.layout.fragment_internet_pockets
    override val vm: TariffVM
        get() = ViewModelProvider(this).get(TariffVM::class.java)
}