package com.example.techpoint.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techpoint.adapter.LibraryAdapter
import com.example.techpoint.databinding.FragmentLibraryBinding
import com.example.techpoint.model.BookDataSet

class LibraryFragment : Fragment() {

    val cours = listOf(
        BookDataSet(
            title = "Основы математики",
            subtitle = "Для начинающих",
            imageResource = "https://free.atamura.kz/wp-content/uploads/2020/04/%D0%93%D0%B5%D0%BE%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%8F_%D0%A0%D0%A8_9%D0%BA%D0%BB%D0%B0%D1%81%D1%81.jpg"
        ),
        BookDataSet(
            title = "Алгебра",
            subtitle = "Для студентов",
            imageResource = "https://free.atamura.kz/wp-content/uploads/2020/04/%D0%93%D0%B5%D0%BE%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%8F_%D0%A0%D0%A8_9%D0%BA%D0%BB%D0%B0%D1%81%D1%81.jpg"
        ),
        BookDataSet(
            title = "Геометрия",
            subtitle = "Для всех",
            imageResource = "https://free.atamura.kz/wp-content/uploads/2020/04/%D0%93%D0%B5%D0%BE%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%8F_%D0%A0%D0%A8_9%D0%BA%D0%BB%D0%B0%D1%81%D1%81.jpg"
        )
    )

    private var _binding: FragmentLibraryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLibraryBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = LibraryAdapter(requireContext(), cours)
        binding.recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.setLayoutManager(linearLayoutManager);
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}