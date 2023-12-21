package com.example.techpoint.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.techpoint.adapter.CourseAdapter
import com.example.techpoint.R
import com.example.techpoint.databinding.FragmentHomeBinding
import com.example.techpoint.model.Course


class HomeFragment : Fragment() {

    val courses = listOf(
        Course(
            title = "Основы математики",
            subtitle = "Для начинающих",
            imageResource = R.drawable.math_basics
        ),
        Course(
            title = "Алгебра",
            subtitle = "Для студентов",
            imageResource = R.drawable.algebra
        ),
        Course(
            title = "Геометрия",
            subtitle = "Для всех",
            imageResource = R.drawable.geometry
        )
    )

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = CourseAdapter(courses)
        binding.recyclerView.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}