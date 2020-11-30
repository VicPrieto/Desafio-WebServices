package com.digitalhouse.desafio.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalhouse.desafio.models.HQ
import com.digitalhouse.desafio.services.Repository
import com.digitalhouse.desafio.services.repository
import kotlinx.coroutines.launch

class MainViewModel (val service: Repository): ViewModel() {
    val listaHQ = MutableLiveData<ArrayList<HQ>>()

    fun getAll(){
        viewModelScope.launch {
            Log.i(
                "TAG", repository.getResults(
                    1,
                    10,
                    1,
                    "35ad1d6a890da5ea66ebdf44e423d42c",
                    "40a3aa568bb269dfad85ae0c4a297181"
                ).toString()
            )
        }
    }
}