package com.digitalhouse.desafio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.services.service
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var lManager: GridLayoutManager
    var page: Int = 1

    private val viewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lManager = GridLayoutManager(this, 3)
        rvHQ.layoutManager = lManager

        itemAdapter = ItemAdapter()
        rvHQ.adapter = itemAdapter


        viewModel.listaHQ.observe(this){
            itemAdapter.addHQ(it)
        }

        viewModel.getAll()
        setScrollView()
    }

    private fun setScrollView(){
        rvHQ.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val itensVisible = lManager?.childCount
                    val pastItens = lManager.findFirstVisibleItemPosition()
                    var total = itemAdapter?.itemCount

                    if (itensVisible + pastItens == total) {
                        page++
                        viewModel.getAll()
                    }
                }
            })
        }

    }
}