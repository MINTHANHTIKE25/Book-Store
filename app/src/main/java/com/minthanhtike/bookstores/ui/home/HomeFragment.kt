package com.minthanhtike.bookstores.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.minthanhtike.bookstores.databinding.FragmentHomeBinding
import com.minthanhtike.bookstores.domain.CategoryContainer
import com.minthanhtike.bookstores.ui.adapter.HomeAdapter
import com.minthanhtike.bookstores.ui.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=HomeAdapter()
        binding.homeRecyclerView.adapter=adapter
        binding.homeRecyclerView.layoutManager=LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        var list = listOf<CategoryContainer>()
        homeViewModel.bookUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeViewModel.BookScreenState.Success -> {
                    adapter.updateData(list + it.books)
                }
                is HomeViewModel.BookScreenState.CategorySuccess->{
                    list=it.categorise
                }
                else -> {}
            }
        }
        homeViewModel.bookUiEvent.observe(viewLifecycleOwner){
            when(it){
                is HomeViewModel.BookUiEvent.Error -> {
                    Toast.makeText(this.context, it.message, Toast.LENGTH_SHORT).show()
                }

                else -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}