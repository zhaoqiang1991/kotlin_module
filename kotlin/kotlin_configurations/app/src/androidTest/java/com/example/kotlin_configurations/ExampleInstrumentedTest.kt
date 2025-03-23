package com.example.kotlin_configurations

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        System.setProperty("kotlinx.coroutines.debug", "on" )

        Log.d("lh", "1 ========test1")
        // 启动协程执行后台任务

        runBlocking {
            val result = fetchData()
            Log.d("lh", "3 ========launch 1 当前线程名字${Thread.currentThread().name}")
            Log.d("lh", "4 ========launch 2 当前线程名字${Thread.currentThread().name}")
            Log.d("lh", "7 ========result结果是 $result")
        }
        Log.d("lh", "2 ========test1")
    }

    private suspend fun fetchData(): String {
        Log.d("lh", "5 ========fetchData当前线程名字${Thread.currentThread().name}")
        return withContext(Dispatchers.IO) {
            Log.d("lh", "6 ========fetchData当前线程名字${Thread.currentThread().name}")
            //delay(1000) // 模拟耗时任务 (2s)
            //Thread.sleep(2000)
            "数据加载完成 ✅"
        }
    }

}