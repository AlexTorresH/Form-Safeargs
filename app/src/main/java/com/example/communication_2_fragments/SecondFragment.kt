package com.example.communication_2_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.communication_2_fragments.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!
    private var name: String ? = ""
    private var lastName: String  = ""
    private var age : Int ? = 0
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = args.student.name
        lastName = args.student.lastName
        age = args.student.age
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("num1","a")
        Log.e("num2", "$name")
        _binding?.textView5?.text = "Hola ${name} ${lastName} tienes ${age} años"
        //setFragmentResultListener("requestKey"){ key, bundle ->
            //val num1 = bundle.getInt("bundlekey")
            //Log.e("num1","Este es el valor num1 $num1")
            //val num2 = bundle.getInt("bundlekey2")
            //print(num2)
            //val suma = num1+num2
            //_binding?.textView?.setText("${suma}")
        //}

        binding.button2.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}