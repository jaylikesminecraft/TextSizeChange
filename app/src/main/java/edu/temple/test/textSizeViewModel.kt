package edu.temple.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class textSizeViewModel :  ViewModel() {

    private val textSize : MutableLiveData<Float> = MutableLiveData<Float>()

    fun getText () : LiveData<Float> {
        return textSize
    }

    fun setText (size: Float) {
        textSize.value = size
    }

}