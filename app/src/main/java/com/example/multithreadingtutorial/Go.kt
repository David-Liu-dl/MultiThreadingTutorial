package com.example.multithreadingtutorial

import android.app.Activity
import android.widget.ProgressBar
import android.widget.TextView

interface Go {
  val tag: String

  fun runTask(progressBar: ProgressBar, textview: TextView, activity: Activity)
}
