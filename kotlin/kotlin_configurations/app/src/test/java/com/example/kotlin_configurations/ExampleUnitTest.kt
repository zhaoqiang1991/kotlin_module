package com.example.kotlin_configurations

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
/*
参考资料 https://blog.csdn.net/qq_14876133/article/details/123737518
https://zhuanlan.zhihu.com/p/563249412
 */
class ExampleUnitTest {

    @Test
    fun useAppContext() {
        log("1 ========test1")
        // 启动协程执行后台任务
        runBlocking {
            val result = fetchData()
            log("3 ========launch 1 当前线程名字${Thread.currentThread().name}")
            log("4 ========launch 2 当前线程名字${Thread.currentThread().name}")
        }
        log("2 ========test1")
    }

    private suspend fun fetchData(): String {
        log("5 ========fetchData当前线程名字${Thread.currentThread().name}")
        return withContext(Dispatchers.IO) {
            log("6 ========fetchData当前线程名字${Thread.currentThread().name}")
            delay(1000) // 模拟耗时任务 (2s)
            //Thread.sleep(2000)
            "数据加载完成 ✅"
        }
    }

    fun log(info: String) {
        println( info)
    }
}