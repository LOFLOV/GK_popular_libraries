package com.android.gk_popular_libraries

class CountersModel {

    private val counters = mutableListOf(0, 0, 0)

    private fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun next(position: Int): Int {
        return counters[position]++
    }

    fun set(position: Int, value: Int) {
        counters[position] = value
    }
}