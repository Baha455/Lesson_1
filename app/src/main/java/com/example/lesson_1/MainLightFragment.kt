package com.example.lesson_1

import TriviaCategoriesResponse
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
        //setupSpinnerAdapter()
        start()
    }

    /*private fun setupSpinnerAdapter() {
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

    }*/

    private fun start() {
        binding.start.setOnClickListener {
            App.service.getCategory().enqueue(object : Callback<TriviaCategoriesResponse>{
                override fun onResponse(
                    call: Call<TriviaCategoriesResponse>,
                    response: Response<TriviaCategoriesResponse>
                ) {
                        val data = response.body()
                        var nameCategory = arrayListOf<String>()
                    response.body()?.triviaCategories?.forEach{
                        nameCategory.add(it.name)

                    }
                    val adapter = ArrayAdapter(
                        requireContext(),
                        R.layout.customtxt,
                        nameCategory
                    )
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                    binding.spinnerFirst.setAdapter(adapter)

                }

                override fun onFailure(call: Call<TriviaCategoriesResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}