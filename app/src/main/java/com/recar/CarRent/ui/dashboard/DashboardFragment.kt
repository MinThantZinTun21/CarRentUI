package com.recar.CarRent.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.recar.CarRent.R
import com.recar.CarRent.component.GoGetMap
import com.recar.CarRent.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null
    lateinit var getGoMap: GoGetMap
    lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initUi()
        return root
    }

    private fun initUi() {
        loadGetGoMap()
        binding.root.apply {
            findViewById<Button>(R.id.button).setOnClickListener {
                findNavController().navigate(R.id.action_navigate_to_car_search_result_fragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadGetGoMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { p0 ->
            p0?.let {
                getGoMap = GoGetMap(requireActivity(), it)
                getGoMap.drawCircle()
                getGoMap.showMarkerWithBond()
            }
        }
    }


}