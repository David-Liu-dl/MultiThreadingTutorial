package com.example.multithreadingtutorial

import android.app.Activity
import android.widget.ProgressBar
import android.widget.TextView

object GoAndroidNative : Go {
  override val tag: String = "GoAndroidNative"

  override fun runTask(progressBar: ProgressBar, textview: TextView, activity: Activity) {
    // Running a task in a separate thread
    val thread = object : Thread() {
      override fun run() {
        try {
          progressBar.progress = 0
          sleep(3000)
          progressBar.progress = 100
          // textview.text = "GoAndroidNative" // Update text from working thread
          activity.runOnUiThread { textview.text = tag } // Update text from main thread
        } catch (e: InterruptedException) {
          e.printStackTrace()
        }
      }
    }

    thread.start()
  }
}
