package com.digitalhouse.desafio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.services.repository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    val viewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        itemAdapter = ItemAdapter()
        gridLayoutManager = GridLayoutManager(this, 3)
        rvHQ.layoutManager = gridLayoutManager
        rvHQ.adapter = itemAdapter
        rvHQ.hasFixedSize()

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

                    if (dy > 0){
                        var litem = itemAdapter?.itemCount
                        val vItem = gridLayoutManager.findFirstVisibleItemPosition()
                        val itens = itemAdapter.itemCount
                        if (litem + vItem >= itens){
                            viewModel.getAll()
                        }
                    }
//                    val itensVisible = gridLayoutManager?.childCount
                }
            })
        }

    }
}