package com.example.lesson_1

import Trivia_categories
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lesson_1.databinding.FragmentMainLightBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainLightFragment: Fragment() {
    private lateinit var binding: FragmentMainLightBinding
    private val viewModel: MainLightFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainLightBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinnerAdapter()
        start()
    }

    private fun setupSpinnerAdapter() {
        context?.let {
            ArrayAdapter.createFromResource(
                it.applicationContext,
                R.array.planets_array,
                R.layout.customtxt
            ).also { adapter ->
                adapter.setDropDownViewResource(R.layout.customtxt)
                binding.spinnerFirst.adapter = adapter
                binding.spinnerSecond.adapter = adapter
            }
        }

    }

    private fun start() {
        binding.start.setOnClickListener {
            App.service.getCategory().enqueue(object : Callback<Trivia_categories>{
                override fun onResponse(
                    call: Call<Trivia_categories>,
                    response: Response<Trivia_categories>
                ) {
                        val data = response.body()
                        binding.tvTest.text = data?.name

                }

                override fun onFailure(call: Call<Trivia_categories>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}