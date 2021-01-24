package com.example.barcodemlkit.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.barcodemlkit.LiveBarcodeScanningActivity
import com.example.barcodemlkit.R
import com.example.barcodemlkit.Utils

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val button: Button = root.findViewById(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(requireActivity(), LiveBarcodeScanningActivity::class.java))
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        if (!Utils.allPermissionsGranted(requireContext())) {
            Utils.requestRuntimePermissions(requireActivity())
        }
    }
}