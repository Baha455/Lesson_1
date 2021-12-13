package com.example.lesson_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.lesson_1.databinding.FragmentMainLightBinding

class MainLightFragment: Fragment() {
   private lateinit var binding: FragmentMainLightBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainLightBinding.inflate(layoutInflater)
        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinnerAdapter()
    }

    private fun setupSpinnerAdapter(){
        context?.let {
            ArrayAdapter.createFromResource(
                it.applicationContext,
                R.array.planets_array,
                R.layout.customtxt
            ).also { adapter -> adapter.setDropDownViewResource(R.layout.customtxt)
                binding.spinnerFirst.adapter = adapter
                binding.spinnerSecond.adapter = adapter}
        }

    }
}