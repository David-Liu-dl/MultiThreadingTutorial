package com.example.multithreadingtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val progressBar = findViewById<ProgressBar>(R.id.progressBar1)
    val textview = findViewById<TextView>(R.id.textview)

    findViewById<Button>(R.id.btn_main).apply {
      text = GoMainThread.tag
      setOnClickListener { GoMainThread.runTask(progressBar, textview, this@MainActivity) }
    }

    findViewById<Button>(R.id.btn_native).apply {
      text = GoAndroidNative.tag
      setOnClickListener { GoAndroidNative.runTask(progressBar, textview, this@MainActivity) }
    }

    findViewById<Button>(R.id.btn_rx).apply {
      text = GoRxJava.tag
      setOnClickListener { GoRxJava.runTask(progressBar, textview, this@MainActivity) }
    }

    findViewById<Button>(R.id.btn_coroutine).apply {
      text = GoCoroutine.tag
      setOnClickListener { GoCoroutine.runTask(progressBar, textview, this@MainActivity) }
    }
  }
}
