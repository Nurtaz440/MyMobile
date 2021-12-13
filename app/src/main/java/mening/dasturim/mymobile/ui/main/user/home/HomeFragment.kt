package mening.dasturim.mymobile.ui.main.user.home

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.constants.Constants
import mening.dasturim.mymobile.databinding.FragmentHomeBinding
import mening.dasturim.mymobile.ui.base.BaseFragment
import mening.dasturim.mymobile.utils.ViewUtils

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>() {
    override fun onBound() {
        setUp()
    }

    fun setUp() {

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


        //navigate Mobiuz
        binding.cvIconRed.setOnClickListener {
            findNavController().navigate(R.id.rateFragment)
        }
        binding.cvIconRed2.setOnClickListener {
            findNavController().navigate(R.id.internetPocketsFragment)
        }

        binding.cvIconRed3.setOnClickListener {
            findNavController().navigate(R.id.minutesFragment)
        }
        binding.cvIconRed4.setOnClickListener {
            findNavController().navigate(R.id.messageFragment)
        }

        binding.cvIconRed5.setOnClickListener {
            findNavController().navigate(R.id.USSDFragment)
        }
        binding.cvIconRed6.setOnClickListener {
            findNavController().navigate(R.id.servicesFragment)
        }

        //navigate Ucell
        binding.cvIconViolet.setOnClickListener {
            findNavController().navigate(R.id.rateFragment)
        }
        binding.cvIconViolet2.setOnClickListener {
            findNavController().navigate(R.id.internetPocketsFragment)
        }

        binding.cvIconViolet3.setOnClickListener {
            findNavController().navigate(R.id.minutesFragment)
        }
        binding.cvIconViolet4.setOnClickListener {
            findNavController().navigate(R.id.messageFragment)
        }

        binding.cvIconViolet5.setOnClickListener {
            findNavController().navigate(R.id.USSDFragment)
        }
        binding.cvIconViolet6.setOnClickListener {
            findNavController().navigate(R.id.servicesFragment)
        }


        //navigate Beeline
        binding.cvIconYellow.setOnClickListener {
            findNavController().navigate(R.id.rateFragment)
        }
        binding.cvIconYellow2.setOnClickListener {
            findNavController().navigate(R.id.internetPocketsFragment)
        }

        binding.cvIconYellow3.setOnClickListener {
            findNavController().navigate(R.id.minutesFragment)
        }
        binding.cvIconYellow4.setOnClickListener {
            findNavController().navigate(R.id.messageFragment)
        }

        binding.cvIconYellow5.setOnClickListener {
            findNavController().navigate(R.id.USSDFragment)
        }
        binding.cvIconYellow6.setOnClickListener {
            findNavController().navigate(R.id.servicesFragment)
        }


        binding.cvCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.fromParts("tel", Constants.CALL_CENTER_NUMBER_UZMOBILE, null)
            startActivity(intent)

        }

        binding.cvUzmobile.setOnClickListener {
            //
            ViewUtils.fadeIn(binding.cvItem)
            ViewUtils.fadeOut(binding.cvItem2)
            ViewUtils.fadeOut(binding.cvItem3)
            ViewUtils.fadeOut(binding.cvItem4)

            // services
            ViewUtils.fadeIn(binding.scroll)
            ViewUtils.fadeOut(binding.scroll2)
            ViewUtils.fadeOut(binding.scroll3)
            ViewUtils.fadeOut(binding.scroll4)

            //stroke should be
            binding.cvUzmobile.strokeColor = ContextCompat.getColor(
                requireContext(),
                R.color.deep_sky_blue_400
            )
            binding.cvUzmobile.strokeWidth = 2

            //call number
            binding.cvCall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.fromParts("tel", Constants.CALL_CENTER_NUMBER_UZMOBILE, null)
                startActivity(intent)

            }

            //text should be
            binding.tvMain.setText(R.string.uzmobile)
            binding.tvNumber.setText(R.string.call_center_number)

        }
        binding.cvMobiuz.setOnClickListener {
            ViewUtils.fadeIn(binding.cvItem2)
            ViewUtils.fadeOut(binding.cvItem)
            ViewUtils.fadeOut(binding.cvItem3)
            ViewUtils.fadeOut(binding.cvItem4)

            // services
            ViewUtils.fadeIn(binding.scroll2)
            ViewUtils.fadeOut(binding.scroll)
            ViewUtils.fadeOut(binding.scroll3)
            ViewUtils.fadeOut(binding.scroll4)

            //stroke should be
            binding.cvMobiuz.strokeColor = ContextCompat.getColor(
                requireContext(),
                R.color.alizarin_700
            )
            binding.cvMobiuz.strokeWidth = 2

            //text should be
            binding.tvMain.setText(R.string.mobiuz)
            binding.tvNumber2.setText(R.string.call_center_number_mobiuz)


            //call number
            binding.cvCallRed.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.fromParts("tel", Constants.CALL_CENTER_NUMBER_MOBIEUZ, null)
                startActivity(intent)


            }
        }

        binding.cvUcell.setOnClickListener {
            ViewUtils.fadeIn(binding.cvItem3)
            ViewUtils.fadeOut(binding.cvItem2)
            ViewUtils.fadeOut(binding.cvItem)
            ViewUtils.fadeOut(binding.cvItem4)

            // services
            ViewUtils.fadeIn(binding.scroll3)
            ViewUtils.fadeOut(binding.scroll2)
            ViewUtils.fadeOut(binding.scroll)
            ViewUtils.fadeOut(binding.scroll4)

            //stroke should be
            binding.cvUcell.strokeColor = ContextCompat.getColor(
                requireContext(),
                R.color.vivid_violet_800
            )

            binding.cvUcell.strokeWidth = 2

            //text should be
            binding.tvMain.setText(R.string.ucell)
            binding.tvNumber3.setText(R.string.call_center_number_ucell)

            //call number
            binding.cvCallViolet.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.fromParts("tel", Constants.CALL_CENTER_NUMBER_UCELL, null)
                startActivity(intent)

            }
        }
        binding.cvBeeline.setOnClickListener {
            ViewUtils.fadeIn(binding.cvItem4)
            ViewUtils.fadeOut(binding.cvItem2)
            ViewUtils.fadeOut(binding.cvItem3)
            ViewUtils.fadeOut(binding.cvItem)

            // services
            ViewUtils.fadeIn(binding.scroll4)
            ViewUtils.fadeOut(binding.scroll2)
            ViewUtils.fadeOut(binding.scroll3)
            ViewUtils.fadeOut(binding.scroll)

            //stroke should be
            binding.cvBeeline.strokeColor = ContextCompat.getColor(
                requireContext(),
                R.color.gorse_600
            )
            binding.cvBeeline.strokeWidth = 2

            //text should be
            binding.tvMain.setText(R.string.beeline)
            binding.tvNumber4.setText(R.string.call_center_number_beeline)

            //call number
            binding.cvCallYellow.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.fromParts("tel", Constants.CALL_CENTER_NUMBER_BEELINE, null)
                startActivity(intent)


            }
        }

    }


    override fun getLayoutResId() = R.layout.fragment_home
    override val vm: HomeVM
        get() = ViewModelProvider(this).get(HomeVM::class.java)


}