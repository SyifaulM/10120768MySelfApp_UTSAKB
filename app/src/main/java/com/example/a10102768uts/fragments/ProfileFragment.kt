package com.example.a10102768uts.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.a10102768uts.R

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    private lateinit var call: ImageView
    private lateinit var email: ImageView
    private lateinit var instagram: ImageView
    private lateinit var maps: ImageView
    private lateinit var appInfo: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        call = view.findViewById(R.id.call)
        email = view.findViewById(R.id.mail)
        instagram = view.findViewById(R.id.ig)
        maps = view.findViewById(R.id.map)
        appInfo = view.findViewById(R.id.about)

        call.setOnClickListener { openCallKeypad() }
        email.setOnClickListener { sendEmail() }
        instagram.setOnClickListener { openInstagram() }
        maps.setOnClickListener { openMaps() }
        appInfo.setOnClickListener { openAppInfoDialog() }

        return view
    }

    private fun openCallKeypad() {
        val nomer = "0895386782836"
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomer"))
        startActivity(intent)
    }

    private fun sendEmail() {
        val email = "syifaul.10120768@mahasiswa.unikom.ac.id"
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), "No email found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openInstagram() {
        val usn = "syifa.ulm"
        val uri = Uri.parse("https://www.instagram.com/$usn")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), "Instagram app not found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openMaps() {
        val latitude = -6.9178022
        val longitude = 107.6564371
        val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), "Maps app not found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openAppInfoDialog() {
        val dialog = AppInfoDialogFragment()
        dialog.show(childFragmentManager, "app_info_dialog")
    }

    class AppInfoDialogFragment : DialogFragment() {

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(requireContext())
            val inflater = requireActivity().layoutInflater
            val dialogView = inflater.inflate(R.layout.app_info, null)

            builder.setView(dialogView)

            return builder.create()
        }
    }
}