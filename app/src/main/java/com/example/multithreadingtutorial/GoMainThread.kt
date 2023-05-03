package com.example.multithreadingtutorial

import android.app.Activity
import android.widget.ProgressBar
import android.widget.TextView

object GoMainThread : Go {
  override val tag: String = "GoMainThread"

  override fun runTask(progressBar: ProgressBar, textview: TextView, activity: Activity) {
    // simulated long-running task
    Thread.sleep(3000)
    textview.text = tag
  }
}
