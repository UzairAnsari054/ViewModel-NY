package com.example.viewmodel_ny

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var itemCount = MutableLiveData<Int>()

    init {
        itemCount.value = 0
    }

    fun updateItemCount() {
        val currentCount = itemCount.value ?: 0
        itemCount.value = currentCount + 1
    }
}