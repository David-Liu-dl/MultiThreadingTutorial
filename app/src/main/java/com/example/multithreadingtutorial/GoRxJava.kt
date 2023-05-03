package com.example.multithreadingtutorial

import android.app.Activity
import android.widget.ProgressBar
import android.widget.TextView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS

object GoRxJava : Go {
  override val tag: String = "GoRxJava"

  override fun runTask(progressBar: ProgressBar, textview: TextView, activity: Activity) {
    val disposable: Disposable = Observable.fromCallable {
      Thread.sleep(3000)
      tag
    }
      .observeOn(AndroidSchedulers.mainThread()) // Defines which thread we're observing on
      .subscribeOn(Schedulers.io()) // Defines which thread the blocking code will be running on
      .subscribe {
        textview.text = it
      }

    val disposable2: Disposable = Observable.interval(300, MILLISECONDS).repeat(10)
      .doOnSubscribe { progressBar.progress = 0 }
      .doOnEach {
      progressBar.progress += 10
    } .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe()

    // Question: what is disposable? How we're gonna deal with it?
    // Question: Why io thread still can handle the ticker while being blocked?
  }
}
