package com.jetpack.composebasics.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    /*This will observe the state */
    val textFieldState = MutableLiveData("")

    /*Whenever onChange will call then newText textFieldState value will change and LiveData will observe the change on the State*/
    fun onTextChange(newText: String) {
        textFieldState.value = newText
    }
}