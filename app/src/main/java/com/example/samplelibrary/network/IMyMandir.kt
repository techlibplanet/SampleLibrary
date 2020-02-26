package com.example.samplelibrary.network

import com.example.samplelibrary.models.MyMandirModel
import io.reactivex.Observable
import retrofit2.http.GET

interface IMyMandir {

    @GET("dummy")
    fun getData(): Observable<MutableList<MyMandirModel>>
}