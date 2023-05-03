# MultiThreadingTutorial

This project simply demonstrates what is multi-threading in Android and some common ways to achieve multi-threading.

The main screen has the following buttons and it will go with different way to do a multi-threading work.

- GoMainThread: Everything is running on the Main thread.
- GoAndroidNative: There are two versions of code to illustrate the issue of updating UI in non-main-thread.
  - Update text from working thread
  - Update text from main thread
- GoRxJava: Run the task in a IO thread and update the text in main thread. It illustrates multiple works can be running in IO thread simultaneously.
- GoCoroutine:  Run the task in a IO scope and update the text in main scope. It illustrates multiple coroutines can be running in same scope simultaneously.
