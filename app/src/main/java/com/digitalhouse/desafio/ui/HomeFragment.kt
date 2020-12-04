package com.digitalhouse.desafio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.models.HQ
import com.digitalhouse.desafio.services.repository
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), ItemAdapter.OnComicClickListener {
    lateinit var itemAdapter: ItemAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var listHQ: HQ


    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gridLayoutManager = GridLayoutManager(context, 3)
        rvHQ.layoutManager = gridLayoutManager
        rvHQ.hasFixedSize()

        viewModel.list.observe(viewLifecycleOwner) {
            itemAdapter = ItemAdapter(it, this)
            listHQ = it
            rvHQ.adapter = itemAdapter
        }

        viewModel.getAll()
    }

    override fun comicClick(position: Int) {
        val bundle = bundleOf(
            "hq" to listHQ.data.results[position])

        findNavController().navigate(R.id.action_homeFragment_to_detalheFragment, bundle)
    }
}