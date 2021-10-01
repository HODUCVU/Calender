package com.example.canlender

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.canlender.data.Object
import com.example.canlender.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterPlan: AdapterPlan

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycle)
        init()
    }
    private fun init() {
        adapterPlan = AdapterPlan(this, Object.listPlan)
        recyclerView.adapter = adapterPlan
        adapterPlan.notifyDataSetChanged()
        recyclerView.setHasFixedSize(true)
    }
    fun gotoPlan() {
        findNavController().navigate(R.id.action_SecondFragment_to_plan)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}