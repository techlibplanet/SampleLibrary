package com.example.samplelibrary.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.samplelibrary.helper.processRequest
import com.example.samplelibrary.network.IMyMandir
import io.reactivex.disposables.CompositeDisposable

class MyMandirViewModel(private val myMandirService: IMyMandir) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    fun getData() {
        compositeDisposable.add(myMandirService.getData()
            .processRequest(
                {
                    for (data in it) {
                        Log.d("Id", data.id.toString())
                        Log.d("Title", data.title)
                        Log.d("Time stamp", data.timeStamp)
                    }
                }, { err ->
                    Log.d("Error", err)
                }
            ))
    }

}