package dev.masian.myapplication

import NamesRvAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.masian.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var namesAdapter: NamesRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fibonacciList = generateFibonacciNumbers(100)
        val fibonacciNamesList = fibonacciList.map { it.toString() }

        namesAdapter = NamesRvAdapter(fibonacciNamesList)
        binding.rvNames.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = namesAdapter
        }
    }

    private fun generateFibonacciNumbers(count: Int): List<Int> {
        val fibonacciList = mutableListOf<Int>()
        var a = 0
        var b = 1
        fibonacciList.add(a)
        fibonacciList.add(b)
        for (i in 2 until count) {
            val c = a + b
            fibonacciList.add(c)
            a = b
            b = c
        }
        return fibonacciList
    }

    override fun onResume() {
        super.onResume()
        namesAdapter.notifyDataSetChanged()
    }
}