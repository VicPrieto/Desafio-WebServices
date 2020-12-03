package com.digitalhouse.desafio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.models.HQ
import com.digitalhouse.desafio.services.repository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), ItemAdapter.OnComicClickListener {

    lateinit var itemAdapter: ItemAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var listHQ: HQ

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

        gridLayoutManager = GridLayoutManager(this, 3)
        rvHQ.layoutManager = gridLayoutManager
        rvHQ.hasFixedSize()

        viewModel.list.observe(this){
            itemAdapter = ItemAdapter(it, this)
            listHQ = it
            rvHQ.adapter = itemAdapter
        }

        viewModel.getAll()
//        setScrollView()
    }

    override fun comicClick(position: Int) {
//        val hq = MainFragmentDirections.actionMainFragmentToComicDetailFragment(listHQ.data.results[position])
//        findNavController().navigate(comic)
    }

//    private fun setScrollView(){
//        rvHQ.run {
//            addOnScrollListener(object : RecyclerView.OnScrollListener(){
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    if (dy > 0){
//                        var litem = itemAdapter?.itemCount
//                        val vItem = gridLayoutManager.findFirstVisibleItemPosition()
//                        val itens = itemAdapter.itemCount
//                        if (litem + vItem >= itens){
//                            viewModel.getAll()
//                        }
//                    }
//                    val itensVisible = gridLayoutManager?.childCount
//                }
//            })
//        }
//
//    }
}