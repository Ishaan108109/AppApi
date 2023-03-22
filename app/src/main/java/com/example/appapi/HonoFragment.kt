package com.example.appapi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appapi.databinding.FragmentHonoBinding
import com.example.appapi.databinding.RecyclerviewHonoBinding

class HonoFragment : Fragment() {


    private lateinit var viewModel: HonoViewModel



    private lateinit var binding: FragmentHonoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHonoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[HonoViewModel::class.java]

       binding.button.setOnClickListener{
           viewModel.getItems()
       }

        viewModel.hono.observe(viewLifecycleOwner, Observer {
            Log.d("Hello", "onActivityCreated: $it")
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,FragmentB()).commit()



        })


    }



}
