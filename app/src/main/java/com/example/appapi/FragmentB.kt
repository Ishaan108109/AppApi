package com.example.appapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appapi.databinding.FragmentBBinding
import com.example.appapi.databinding.FragmentHonoBinding

class FragmentB : Fragment() {



    private lateinit var viewModel: HonoViewModel



    private lateinit var binding: FragmentBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[HonoViewModel::class.java]


        viewModel.hono.observe(viewLifecycleOwner, Observer {
            Log.d("Hello", "onActivityCreated: $it")
//            parentFragmentManager.beginTransaction().add(R.id.fragmentContainerView,FragmentB()).commit()

            val adapter = HonoAdapter(it)
            binding.recyclerViewHono.layoutManager= LinearLayoutManager(requireContext())
            binding.recyclerViewHono.adapter = adapter

        })


    }
}