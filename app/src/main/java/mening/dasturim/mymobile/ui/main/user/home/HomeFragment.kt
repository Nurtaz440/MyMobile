package mening.dasturim.mymobile.ui.main.user.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentHomeBinding
import mening.dasturim.mymobile.ui.Companies
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>() {
    private lateinit var homeAdapter: HomeAdapter
    override fun onBound() {
        setUp()
    }

    fun setUp() {
        CompanyState.getCompany().observe(this, Observer {
            Log.d("Observe", it.toString())
            when (it) {
                Companies.UZMOBILE -> {
                    homeAdapter.setColor(R.color.deep_sky_blue_400)
                    companyUzmobile()
                }
                Companies.MOBIUZ -> {
                    homeAdapter.setColor(R.color.alizarin_700)
                    companyMobiuz()
                }
                Companies.UCELL -> {
                    homeAdapter.setColor(R.color.vivid_violet_800)
                    companyUcell()
                }
                Companies.BEELINE -> {
                    homeAdapter.setColor(R.color.gorse_600)
                    companyBeeline()
                }
            }
        })
        homeAdapter = HomeAdapter(requireContext()) {
            when (it) {
                0 -> findNavController().navigate(R.id.rateFragment)
                1 -> findNavController().navigate(R.id.internetPocketsFragment)
                2 -> findNavController().navigate(R.id.minutsPocket)
                3 -> findNavController().navigate(R.id.messageFragment)
                4 -> findNavController().navigate(R.id.USSDFragment)
                5 -> findNavController().navigate(R.id.servicesFragment)

            }
        }
        homeAdapter.setData(Constants.getHomeItems())

        binding.rvMain.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = homeAdapter

        }

        binding.cvUzmobile.setOnClickListener {
            prefs.company = Companies.UZMOBILE.name
            CompanyState.setCompany(Companies.UZMOBILE)
        }
        binding.cvMobiuz.setOnClickListener {
            prefs.company = Companies.MOBIUZ.name
            CompanyState.setCompany(Companies.MOBIUZ)

        }
        binding.cvUcell.setOnClickListener {
            prefs.company = Companies.UCELL.name
            CompanyState.setCompany(Companies.UCELL)

        }
        binding.cvBeeline.setOnClickListener {
            prefs.company = Companies.BEELINE.name
            CompanyState.setCompany(Companies.BEELINE)

        }

    }

    fun companyUzmobile() {
        //card color
        binding.cvItem.setCardBackgroundColor(
            ContextCompat.getColorStateList(
                requireContext(),
                R.color.deep_sky_blue_100
            )
        )
        binding.ivCall.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))
        binding.ivBallans.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))
        binding.cvLogoLarge.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_uzmobile_logo
            )
        )

        //stroke should be
        binding.cvUzmobile.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.deep_sky_blue_400
        )
        binding.cvUzmobile.strokeWidth = 2
        binding.cvMobiuz.strokeWidth = 0
        binding.cvUcell.strokeWidth = 0
        binding.cvBeeline.strokeWidth = 0
        binding.cvCall.setRippleColorResource(R.color.deep_sky_blue_100)
        binding.cvBalans.setRippleColorResource(R.color.deep_sky_blue_100)

        //call number
        binding.cvCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel: %s" + Constants.CALL_CENTER_NUMBER_UZMOBILE)
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        //call number
        binding.cvBalans.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + Uri.encode(Constants.CALL_BALANS))
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    4
                )
            } else {
                startActivity(intent)
            }

        }

        //text should be
        binding.tvMain.setText(R.string.uzmobile)
        binding.tvNumber.setText(R.string.call_center_number)

    }

    fun companyMobiuz() {
        //card color
        binding.cvItem.setCardBackgroundColor(
            ContextCompat.getColorStateList(
                requireContext(),
                R.color.alizarin_100
            )
        )
        binding.ivCall.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))
        binding.ivBallans.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))
        binding.cvLogoLarge.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_mobiuz_logo
            )
        )
        //stroke should be
        binding.cvMobiuz.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.alizarin_700
        )
        binding.cvUzmobile.strokeWidth = 0
        binding.cvMobiuz.strokeWidth = 2
        binding.cvUcell.strokeWidth = 0
        binding.cvBeeline.strokeWidth = 0
        binding.cvCall.setRippleColorResource(R.color.alizarin_100)
        binding.cvBalans.setRippleColorResource(R.color.alizarin_100)

        //text should be
        binding.tvMain.setText(R.string.mobiuz)
        binding.tvNumber.setText(R.string.call_center_number_mobiuz)


        //call number
        binding.cvCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel: %s" + Constants.CALL_CENTER_NUMBER_MOBIEUZ)
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        //call number
        binding.cvBalans.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel: " + Uri.encode(Constants.CALL_BALANS))
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    4
                )
            } else {
                startActivity(intent)
            }

        }
    }


    fun companyUcell() {
        //card color
        binding.cvItem.setCardBackgroundColor(
            ContextCompat.getColorStateList(
                requireContext(),
                R.color.vivid_violet_100
            )
        )
        binding.ivCall.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))
        binding.ivBallans.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))
        binding.cvLogoLarge.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.ic_ucell_logo))
        //stroke should be
        binding.cvUcell.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.vivid_violet_800
        )

        binding.cvUzmobile.strokeWidth = 0
        binding.cvMobiuz.strokeWidth = 0
        binding.cvUcell.strokeWidth = 2
        binding.cvBeeline.strokeWidth = 0
        binding.cvCall.setRippleColorResource(R.color.vivid_violet_100)
        binding.cvBalans.setRippleColorResource(R.color.vivid_violet_100)

        //text should be
        binding.tvMain.setText(R.string.ucell)
        binding.tvNumber.setText(R.string.call_center_number_ucell)
        //call number
        binding.cvCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel: %s" + Constants.CALL_CENTER_NUMBER_UCELL)
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        //call number
        binding.cvBalans.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + Uri.encode(Constants.CALL_BALANS))
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    4
                )
            } else {
                startActivity(intent)
            }

        }
    }

    fun companyBeeline() {
        //card Color
        binding.cvItem.setCardBackgroundColor(
            ContextCompat.getColorStateList(
                requireContext(),
                R.color.gorse_100
            )
        )
        binding.ivCall.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))
        binding.ivBallans.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))
        binding.cvLogoLarge.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_beeline_logo
            )
        )
        //stroke should be
        binding.cvBeeline.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.gorse_600
        )
        binding.cvUzmobile.strokeWidth = 0
        binding.cvMobiuz.strokeWidth = 0
        binding.cvUcell.strokeWidth = 0
        binding.cvBeeline.strokeWidth = 2
        binding.cvCall.setRippleColorResource(R.color.gorse_100)
        binding.cvBalans.setRippleColorResource(R.color.gorse_100)
        //text should be
        binding.tvMain.setText(R.string.beeline)
        binding.tvNumber.setText(R.string.call_center_number_beeline)

        //call number
        binding.cvCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + Constants.CALL_CENTER_NUMBER_BEELINE)
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        //call number
        binding.cvBalans.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + Uri.encode(Constants.CALL_BALANS_BEELINE))
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    4
                )
            } else {
                startActivity(intent)
            }

        }
    }

    override fun getLayoutResId() = R.layout.fragment_home
    override val vm: HomeVM
        get() = ViewModelProvider(this).get(HomeVM::class.java)

}