package com.example.ud03_1_secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.ud03_1_secretapp.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding ? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root
        //val buttonStart = view.findViewById<Button>(R.id.button_start)
        binding.buttonStart.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_messageFragment)
        }
        return view
    }

}