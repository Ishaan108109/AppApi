package com.example.appapi

import android.content.ClipData.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class HonoViewModel(

) : ViewModel() {
    val api = HonoApi()
    val repository = HonoRepository(api)
    private lateinit var job: Job

    private val _hono = MutableLiveData<HonoItems>()
    val hono : LiveData<HonoItems>
    get() = _hono

    fun getItems(){

        job =Coroutines.ioThenMain(
            {repository.getItems()},
            { _hono.value = it }
        )
    }

    override fun onCleared(){
      super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}