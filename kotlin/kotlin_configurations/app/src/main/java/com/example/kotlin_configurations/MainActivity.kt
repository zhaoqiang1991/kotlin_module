package com.example.kotlin_configurations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.kotlin_configurations.ui.theme.Kotlin_configurationsTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_configurationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val result = fetchData()
            log("3 ========launch 1 当前线程名字${Thread.currentThread().name}")
            log("4 ========launch 2 当前线程名字${Thread.currentThread().name}")

            log("7 ========result结果是 $result")
        }
    }

    private suspend fun fetchData(): String {
        log("5 ========fetchData当前线程名字${Thread.currentThread().name}")
        return withContext(Dispatchers.IO) {
            log("6 ========fetchData当前线程名字${Thread.currentThread().name}")
            //delay(1000) // 模拟耗时任务 (2s)
            //Thread.sleep(2000)
            "数据加载完成 ✅"
        }
    }

    fun log(info: String) {
        println(info)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_configurationsTheme {
        Greeting("Android")
    }
}