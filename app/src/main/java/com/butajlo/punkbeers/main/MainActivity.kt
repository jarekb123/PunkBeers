package com.butajlo.punkbeers.main

import android.os.Bundle
import android.os.PersistableBundle
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.usecase.GetRandomBeerUseCase
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var getRandomBeerUseCase: GetRandomBeerUseCase

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        getRandomBeerUseCase.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    tv_beer_id.text = it.id.toString()
                    tv_beer_name.text = it.name
                }.dispose()

    }

}