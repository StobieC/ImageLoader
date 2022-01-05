package com.example.pixelsimagelaoder.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import com.example.pixelsimagelaoder.repository.PexelsRepositoryImpl

class PexelsViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    private val repository = PexelsRepositoryImpl()
    private var input = ""
    private val liveData = MutableLiveData<State>()

    fun getRemoteData(userInput: String): LiveData<State> {
        input = userInput
        fetchRemoteRepository(userInput)
        return liveData
    }

    private fun fetchRemoteRepository(userInput: String) {
        liveData.value = State.Loading
        disposable += repository
            .makeRequests(userInput)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onSuccess = { multipleDataType ->
                multipleDataType?.let { data ->
                    liveData.value = State.Success(data)
                }
            },
                onError = { error ->
                    liveData.value = State.Error
                    Log.d("SEARCH", error.toString())
                }
            )
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}
