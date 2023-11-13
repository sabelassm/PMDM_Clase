package com.example.ud03_1_secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ud03_1_secretapp.databinding.FragmentEncryptBinding
import com.example.ud03_1_secretapp.databinding.FragmentWelcomeBinding

class EncryptFragment : Fragment() {
    private var _binding: FragmentEncryptBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val message = EncryptFragmentArgs.fromBundle(requireArguments()).message
        _binding = FragmentEncryptBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.encryptTextValue.text = cifrado(message)
        return view
    }

    fun cifrado(message: String) = message.map {
        if(it.isLetter())
            it.uppercaseChar().code.minus('A'.code).plus(3).mod(26).plus('A'.code).toChar()
        else
            it
    }.joinToString("")

}