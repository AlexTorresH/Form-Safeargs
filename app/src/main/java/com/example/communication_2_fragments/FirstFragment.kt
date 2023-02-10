package com.example.communication_2_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.communication_2_fragments.databinding.FragmentFirstBinding
import com.example.communication_2_fragments.model.Student


class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener{
            if(!binding.editTextTextPersonName?.text.isNullOrEmpty() && !_binding?.editTextTextPersonName?.text.isNullOrEmpty() && !_binding?.editTextNumber?.text.isNullOrEmpty()){
                //val number1 = _binding?.editTextNumber3?.text.toString().toInt()
                //val number2 = _binding?.editTextNumber4?.text.toString().toInt()
                val name = _binding?.editTextTextPersonName?.text.toString()
                val lastName = _binding?.editTextTextPersonName3?.text.toString()
                val age = _binding?.editTextNumber?.text.toString().toInt()
                val student = Student(name = name,lastName = lastName,age = age)
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(student)
                findNavController().navigate(action)
                Log.e("tag","$student")
                //setFragmentResult("requestKey", bundleOf("bundlekey" to number1, "bundlekey2" to number2))
            }else{
                Toast.makeText(requireContext(), "No haz rellenado todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}