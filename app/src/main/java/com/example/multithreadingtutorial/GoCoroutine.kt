package com.example.multithreadingtutorial

import android.app.Activity
import android.widget.ProgressBar
import android.widget.TextView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object GoCoroutine : Go {
  override val tag: String = "GoCoroutine"

  private val mainScope = MainScope() // ContextScope(SupervisorJob() + Dispatchers.Main)
  private val ioScope = CoroutineScope(Dispatchers.IO)

  override fun runTask(progressBar: ProgressBar, textview: TextView, activity: Activity) {
    // Case-1, run task in main scope and update text in Main scope
    // mainScope.launch {
    //   Thread.sleep(3000)
    //   textview.text = tag
    // }

    // Case-2, run task in IO scope and update text in IO scope
    // ioScope.launch {
    //   Thread.sleep(3000)
    //   textview.text = tag
    // }

    // Case-3, run task in IO scope and update text in Main scope
    ioScope.launch {
      Thread.sleep(3000)

      withContext(Dispatchers.Main) {
        textview.text = tag
      }
    }

    // Timer, we can do that in a different worker
    mainScope.launch {
      progressBar.progress = 0

      repeat(10) {
        delay(300)
        progressBar.progress += 10
      }
    }
  }
}
