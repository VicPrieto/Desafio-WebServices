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
    var list = MutableLiveData<HQ>()

    fun getAll(){
        viewModelScope.launch {
            list.value = service.getResults(
                "1",
                "10",
                "1",
                "focDate",
                "c70e158b477c5ee33c838850e91a0be0",
                "90daceab9123b6f475d9ffeeea6ad19f"
            )
//            Log.i(
//                "TAG", repository.getResults(
//                    1,
//                    10,
//                    1,
//                    "focDate",
//                    "c70e158b477c5ee33c838850e91a0be0",
//                    "90daceab9123b6f475d9ffeeea6ad19f"
//                ).toString()
//            )
        }
    }
}