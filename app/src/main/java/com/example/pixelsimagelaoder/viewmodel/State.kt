package com.example.pixelsimagelaoder.viewmodel

sealed class State {
    object Loading : State()
    data class Success(val mixedDataType: List<Any>) : State()
    object Error : State()
}