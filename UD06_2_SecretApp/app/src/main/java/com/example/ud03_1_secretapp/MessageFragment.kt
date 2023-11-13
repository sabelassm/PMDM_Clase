package com.example.ud03_1_secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.ud03_1_secretapp.databinding.FragmentMessageBinding
import com.example.ud03_1_secretapp.databinding.FragmentWelcomeBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        val view = binding.root
        //val buttonNext = view.findViewById<Button>(R.id.button_nect)
        binding.buttonNect.setOnClickListener {
            val message = binding.editText.text.toString()
            val actions = MessageFragmentDirections.actionMessageFragmentToEncryptFragment(message)
            view.findNavController().navigate(actions)
        }
        return view
    }
}