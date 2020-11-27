package com.digitalhouse.desafio.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalhouse.desafio.models.HQ
import com.digitalhouse.desafio.services.Service
import kotlinx.coroutines.launch

class MainViewModel (val service: Service): ViewModel() {
    val listaHQ = MutableLiveData<ArrayList<HQ>>()

    fun getAll(){
        viewModelScope.launch {
//            listaHQ.value = service.getAllHQ()
        }
    }
}