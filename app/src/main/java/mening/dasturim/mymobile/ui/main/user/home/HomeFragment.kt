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
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentHomeBinding
import mening.dasturim.mymobile.ui.CompanyState
import mening.dasturim.mymobile.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>() {
    private lateinit var navController: NavController
    private lateinit var companyState: CompanyState


    override fun onBound() {
        companyState = CompanyState
        companyState.setCompany(0)
        setUp()

    }

    fun setUp() {

        val navHost = fragmentManager?.findFragmentById(R.id.partial_nav_controller)
        if (navHost != null) {
            navController = navHost.findNavController()
        }

        companyState.getCompany().observe(viewLifecycleOwner, Observer {
            Log.d("Observe", it.toString())
            when (it) {
                companyState.uzmobile -> {
                    companyUzmobile()

                }
                companyState.mobiuz -> {
                    companyMobiuz()
                }
                companyState.ucell -> {
                    companyUcell()
                }
                companyState.beeline -> {
                    companyBeeline()
                }
            }
        })

        binding.cvUzmobile.setOnClickListener {
            companyState.setCompany(0)
        }
        binding.cvMobiuz.setOnClickListener {
            companyState.setCompany(1)
        }
        binding.cvUcell.setOnClickListener {
            companyState.setCompany(2)
        }
        binding.cvBeeline.setOnClickListener {
            companyState.setCompany(3)
        }

        //navigate Uzmobile
        binding.cvIconBlue.setOnClickListener {
            findNavController().navigate(R.id.rateFragment)
        }
        binding.cvIconBlue2.setOnClickListener {
            findNavController().navigate(R.id.internetPocketsFragment)
        }

        binding.cvIconBlue3.setOnClickListener {
            findNavController().navigate(R.id.minutesFragment)
        }
        binding.cvIconBlue4.setOnClickListener {
            findNavController().navigate(R.id.messageFragment)
        }

        binding.cvIconBlue5.setOnClickListener {
            findNavController().navigate(R.id.USSDFragment)
        }
        binding.cvIconBlue6.setOnClickListener {
            findNavController().navigate(R.id.servicesFragment)
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

        //icon color
        binding.ivTariflar.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))
        binding.ivInternet.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))
        binding.ivMassage.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))
        binding.ivMinuts.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))
        binding.ivUssd.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))
        binding.ivServices.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.deep_sky_blue_400))

        //stroke should be
        binding.cvUzmobile.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.deep_sky_blue_400
        )
        binding.cvUzmobile.strokeWidth = 2
        binding.cvMobiuz.strokeWidth = 0
        binding.cvUcell.strokeWidth = 0
        binding.cvBeeline.strokeWidth = 0


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

        //icon color
        binding.ivTariflar.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))
        binding.ivInternet.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))
        binding.ivMassage.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))
        binding.ivMinuts.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))
        binding.ivUssd.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))
        binding.ivServices.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.alizarin_700))

        //stroke should be
        binding.cvMobiuz.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.alizarin_700
        )
        binding.cvUzmobile.strokeWidth = 0
        binding.cvMobiuz.strokeWidth = 2
        binding.cvUcell.strokeWidth = 0
        binding.cvBeeline.strokeWidth = 0


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
            intent.data = Uri.parse("tel: " +Uri.encode(Constants.CALL_BALANS))
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
        binding.cvLogoLarge.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_ucell_logo
            )
        )

        //icon color
        binding.ivTariflar.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))
        binding.ivInternet.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))
        binding.ivMassage.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))
        binding.ivMinuts.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))
        binding.ivUssd.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))
        binding.ivServices.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.vivid_violet_800))

        //stroke should be
        binding.cvUcell.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.vivid_violet_800
        )

        binding.cvUzmobile.strokeWidth = 0
        binding.cvMobiuz.strokeWidth = 0
        binding.cvUcell.strokeWidth = 2
        binding.cvBeeline.strokeWidth = 0
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
            intent.data = Uri.parse("tel:" +Uri.encode(Constants.CALL_BALANS))
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

        //icon Color
        binding.ivTariflar.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))
        binding.ivInternet.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))
        binding.ivMassage.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))
        binding.ivMinuts.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))
        binding.ivUssd.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))
        binding.ivServices.imageTintList =
            (ContextCompat.getColorStateList(requireContext(), R.color.gorse_600))

        //stroke should be
        binding.cvBeeline.strokeColor = ContextCompat.getColor(
            requireContext(),
            R.color.gorse_600
        )
        binding.cvUzmobile.strokeWidth = 0
        binding.cvMobiuz.strokeWidth = 0
        binding.cvUcell.strokeWidth = 0
        binding.cvBeeline.strokeWidth = 2

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
            intent.data = Uri.parse("tel:" +Uri.encode(Constants.CALL_BALANS))
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