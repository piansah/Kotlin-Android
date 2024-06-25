package com.alifalpian.restapi.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alifalpian.restapi.R
import com.alifalpian.restapi.adapter.HomeAdapter
import com.alifalpian.restapi.databinding.FragmentHomeBinding
import com.alifalpian.restapi.viewmodel.ViewModelMahasiswa

class HomeFragment : Fragment(){
    lateinit var viewModel : ViewModelMahasiswa
    lateinit var binding : FragmentHomeBinding
    lateinit var adapter : HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        viewModel.getDataMahasiswa().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvUser.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = HomeAdapter(it)
                binding.rvUser.adapter = adapter
            }else{
                binding.rvUser.visibility = View.GONE
            }
        }
        viewModel.showDataMahasiswa()

        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_AddDataFragment)
        }
    }
}