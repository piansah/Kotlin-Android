package com.alifalpian.restapi.view.Add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alifalpian.restapi.R
import com.alifalpian.restapi.databinding.FragmentAddDataBinding
import com.alifalpian.restapi.viewmodel.ViewModelMahasiswa

class AddDataFragment : Fragment() {
    lateinit var binding : FragmentAddDataBinding
    lateinit var viewModel : ViewModelMahasiswa
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddDataBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ViewModelMahasiswa::class.java)

        binding.btnTambah.setOnClickListener{
            val nim = binding.inputNim.text.toString()
            val nama = binding.inputNama.text.toString()
            val telepon = binding.inputTelepon.text.toString()
            viewModel.insertMahasiswa().observe(viewLifecycleOwner){
                if (it != null){
                    findNavController().navigate(R.id.action_AddDataFragment_to_homeFragment)
                    Toast.makeText(context,"Data berhasil ditambahkan",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,"Data gagal ditambahkan",Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.insertDataMahasiswa(nim,nama,telepon)
        }

        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }
}