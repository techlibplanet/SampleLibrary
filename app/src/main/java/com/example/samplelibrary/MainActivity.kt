package com.example.samplelibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.samplelibrary.viewmodel.MyMandirViewModel
import com.example.samplelibrary.viewmodel.TestViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    val model by viewModel<TestViewModel>()
    val myMandirViewModel by viewModel<MyMandirViewModel>()

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.saveData("Mayank", "Shilpa")
        Timber.d(model.getData())

        compositeDisposable = CompositeDisposable()

        myMandirViewModel.getData()

    }

}
