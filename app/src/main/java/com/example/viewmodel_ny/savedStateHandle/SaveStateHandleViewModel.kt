package com.example.viewmodel_ny.savedStateHandle

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SaveStateHandleViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {

    companion object {
        private const val NAME = "name"
        private const val AGE = "age"
    }

    var name: String?
        get() = stateHandle[NAME]
        set(value) { stateHandle[NAME] = value }

    var age: Int?
        get() = stateHandle[AGE]
        set(value) { stateHandle[AGE] = value }
}